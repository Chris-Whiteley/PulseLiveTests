    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pulselivetests;

/**
 *
 * @author Chris
 */
public class Rectangle {
    // The co-ordinates of the top, left, bottom and right sides

    private double top;
    private double left;
    private double bottom;
    private double right;

    public Rectangle(double top, double left, double bottom, double right) {
        checkArgsValid(top, left, bottom, right);
        this.top = top;
        this.left = left;
        this.bottom = bottom;
        this.right = right;
    }

    public boolean intersects(Rectangle r) {
        return (isBeteween(r.top, this.bottom, this.top)
                || isBeteween(r.bottom, this.bottom, this.top))
                && (isBeteween(r.left, this.left, this.right)
                || isBeteween(r.right, this.left, this.right));
    }

    /**
     * Return true if value is greater than lowValue and less than highValue.
     *
     * @param value
     * @param lowValue
     * @param highValue
     * @return
     */
    private boolean isBeteween(Double value, Double lowValue, Double highValue) {
        return (value.compareTo(lowValue) > 0) && (value.compareTo(highValue) < 0);
    }

    private void checkArgsValid(Double top, Double left, Double bottom, Double right) {
        //check top > botto and right > left

        if (top.compareTo(bottom) <= 0) {
            throw new IllegalArgumentException();
        }

        if (right.compareTo(left) <= 0) {
            throw new IllegalArgumentException();
        }
    }

}
