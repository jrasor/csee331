package ftc.vision;


import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * v 0.1 Adapted by jmr FTC Team 5197 7/31/18 from a creation by
 *       vandejd1 FTC Team EV 7393 on 9/7/16.
 * v 0.2 Adapted by jmr to distinguish Rover Ruckus yellow (Gold Mineral) from white
 *       (Silver Mineral).
 */
public class BeaconProcessor implements ImageProcessor<BeaconColorResult> {
    private static final String TAG = "BeaconProcessor";
    private static final double MIN_MASS = 1.0; // Minimum size of target colored objects

    @Override
    public ImageProcessorResult<BeaconColorResult> process(long startTime, Mat rgbaFrame, boolean saveImages) {
        //save the image in the Pictures directory
        if (saveImages) {
            ImageUtil.saveImage(TAG, rgbaFrame, Imgproc.COLOR_RGBA2BGR, "0_camera", startTime);
        }
        //convert image to hsv
        Mat hsv = new Mat();
        Imgproc.cvtColor(rgbaFrame, hsv, Imgproc.COLOR_RGB2HSV);
        // rgbaFrame is untouched; hsv now contains the same image but using HSV colors

        // This class will create filters to find yellow, green and white.
        // This is done by creating HSV ranges that select each color.
        // The HSV thresholds for each color (yellow, green, white) are stored as a list of min HSV
        // and a list of max HSV.

        List<Scalar> hsvMin = new ArrayList<>();
        List<Scalar> hsvMax = new ArrayList<>();

        // Discriminator filters.
        // Note that in OpenCV, the HSV values have these valid ranges:
        // H: 0 - 179, S: 0-255, V:0-255
        // See https://docs.opencv.org/3.4.2/df/d9d/tutorial_py_colorspaces.html
        // hsvMin.add(new Scalar(  H,   S,   V  ));
        hsvMin.add(new Scalar(  // yellow minimum
                (int) (37 / 360.0 * 179.0),     // Reddest allowed yellow. Was 46.
                (int) (0.60 * 255.0),           // Allow some pastel
                (int) (0.50 * 255.0)));         // Allow some dimming. Was 0.50.
        hsvMax.add(new Scalar(  // yellow max
                (int) (66 / 360.0 * 179.0),     // Greenest allowed yellow
                (int) (1.00 * 255.0),           // Pure color
                (int) (1.00 * 255.0)));         // Fully illuminated

        hsvMin.add(new Scalar( 45,  50, 150));  // green min
        hsvMax.add(new Scalar(75, 255, 255));   // green max

        hsvMin.add(new Scalar( //white min
                0,                              // Allow any color, as long as ...
                (int) (0.00 * 255.0),           // ... it's really gray or white (unsaturated).
                (int) (0.80 * 255.0)));         // Allow some dimming.
        hsvMax.add(new Scalar( //white max
                179,                            // Allow any color, as long as ...
                (int) (0.20 * 255.0),           // ... it's close to white (pastel), and ...
                (int) (1.00 * 255.0)));         // ... really bright.

        // make a list of channels that are blank (used for combining binary images)
        List<Mat> rgbaChannels = new ArrayList<>();

        // For each side of the image, a "color mass" will be computed. This mass is just how
        // much of a color is present on that side (in units of scaled pixels that pass the
        // color filter). This variable keeps track of the mass
        // of the color that ended up having the most "color mass" on each side.
        double [] maxMass = { Double.MIN_VALUE, Double.MIN_VALUE }; //max mass for left and right
        // This next variable keeps track of the color on each side that had the max "color mass"
        // with  0=red  1=green  2=blue  3=UNKNOWN
        // So both sides start as unknown:
        int[] maxMassIndex = { 3, 3}; // index of the max mass

        // We are about to loop over the discriminator filters and compute the "color mass"
        // for each color on each side of the image.

        // These variables are used inside the loop:
        Mat maskedImage;
        Mat colSum = new Mat();
        double mass;
        int[] data = new int[3]; //used to read the colSum

        //loop through the filters
        for(int i=0; i<3; i++) {
            // apply HSV thresholds to select only colors that pass the filters, and
            // render them onto the image as ideal colors: red and blue for Relic
            // Recovery; yellow and white for Rover Ruckus.
            maskedImage = new Mat();
            ImageUtil.hsvInRange(hsv, hsvMin.get(i), hsvMax.get(i), maskedImage);

            //copy the binary image to a channel of rgbaChannels
            rgbaChannels.add(maskedImage);

            //apply a column sum to the (unscaled) binary image
            Core.reduce(maskedImage, colSum, 0, Core.REDUCE_SUM, 4);

            //loop through left and right to calculate mass
            int start = 0;
            int end = hsv.width()/2;
            for(int j=0; j<2; j++){
                //calculate the mass
                mass = 0;
                for(int x=start; x<end; x++){
                    colSum.get(0, x, data);
                    mass += data[0];
                }
                mass /= hsv.size().area(); //scale the mass by the image size

                //if the mass found is greater than the max for this side
                if(mass >= MIN_MASS && mass > maxMass[j]){
                    //this mass is the new max for this side
                    maxMass[j] = mass;
                    //and this index is the new maxIndex for this side
                    maxMassIndex[j] = i;
                }

                start = end;
                end = hsv.width();
            }

        }
        //add empty alpha channel
        rgbaChannels.add(Mat.zeros(hsv.size(), CvType.CV_8UC1));
        //merge the 3 binary images and 1 alpha channel into one image
        Core.merge(rgbaChannels, rgbaFrame);

        //use the maxIndex array to get the left and right colors
        BeaconColorResult.BeaconColor[] beaconColors = BeaconColorResult.BeaconColor.values();
        BeaconColorResult.BeaconColor left = beaconColors[maxMassIndex[0]];
        BeaconColorResult.BeaconColor right = beaconColors[maxMassIndex[1]];

        //draw the color result bars
        int barHeight = hsv.height()/30;
        Imgproc.rectangle(rgbaFrame, new Point(0, 0), new Point(hsv.width()/2, barHeight), left.color, barHeight);
        Imgproc.rectangle(rgbaFrame, new Point(hsv.width()/2, 0), new Point(hsv.width(), barHeight), right.color, barHeight);

        if (saveImages) {
            ImageUtil.saveImage(TAG, rgbaFrame, Imgproc.COLOR_RGBA2BGR, "1_binary", startTime);
        }

        //construct and return the result
        return new ImageProcessorResult<>(startTime, rgbaFrame,
                new BeaconColorResult(left, right)
        );
    }
}
