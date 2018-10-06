package ftc.vision;


import org.opencv.core.Scalar;

/**
 * Storage class for the position and color of the Minerals.
 *
 * v 0.1 by the electronVolts, FTC team 7393, 8/17/16.
 * v 0.2 by jmr FTC 5197, 10/6/18.
 */
public class BeaconColorResult{
  
  public enum BeaconColor{
    YELLOW    (ImageUtil.YELLOW),
    GREEN     (ImageUtil.GREEN),
    WHITE     (ImageUtil.WHITE),
    UNKNOWN   (ImageUtil.BLACK);
    
    public final Scalar color;
    
    BeaconColor(Scalar scalar){
      this.color = scalar;
    }
  }
  private final BeaconColor leftColor, rightColor;
  
  public BeaconColorResult() {
    this.leftColor = BeaconColor.UNKNOWN;
    this.rightColor = BeaconColor.UNKNOWN;
  }
  
  public BeaconColorResult(BeaconColor leftColor, BeaconColor rightColor) {
    this.leftColor = leftColor;
    this.rightColor = rightColor;
  }
  
  public String toString(){
    return leftColor + ", " + rightColor;
  }
  
  public BeaconColor getLeftColor() {
    return leftColor;
  }
  
  public BeaconColor getRightColor() {
    return rightColor;
  }
}
