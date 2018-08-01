package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcontroller.internal.FtcRobotControllerActivity;

import ftc.vision.BeaconColorResult;
import ftc.vision.FrameGrabber;
import ftc.vision.ImageProcessorResult;
import org.opencv.android.CameraBridgeViewBase;
/**
 * Adapted by jmr FTC Team 5197 7/31/18 from a creation by
 * vandejd1 FTC Team EV 7393 on 9/7/16.
 */
@Autonomous(name="Beacon Detect", group="Trainerbot")
//@Disabled
public class BeaconDetectionOp extends LinearOpMode {

  @Override
  public void runOpMode() throws InterruptedException {
    FrameGrabber frameGrabber = FtcRobotControllerActivity.frameGrabber;

    frameGrabber.grabSingleFrame(); //Try to grab a frame.
    while (!frameGrabber.isResultReady()) { //Wait until it gets one.
      Thread.sleep(5);
    }

    // Process it for beacon color order left and right
    ImageProcessorResult imageProcessorResult = frameGrabber.getResult();
    BeaconColorResult result = (BeaconColorResult) imageProcessorResult.getResult();

    BeaconColorResult.BeaconColor leftColor = result.getLeftColor();
    BeaconColorResult.BeaconColor rightColor = result.getRightColor();

    telemetry.addData("Result", result); // Report the color order string.
    telemetry.update();
    //wait before quitting, so Driver can read that telemetry report.
    Thread.sleep(2000);

  }
}
