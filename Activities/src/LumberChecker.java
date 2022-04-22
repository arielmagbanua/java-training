/**
 * This class checks or validates lumber dimensions,
 * where each dimension should not differ more than 1/16.
 */
public class LumberChecker {
    // Epsilon constant value
    public static final double EPSILON = 0.0625;

    /**
     * Validates the dimensional lumber.
     *
     * @param lumber The dimensional lumber instance to validate
     * @return A message whether the dimensions were correct or not.
     */
    public String validate(DimensionalLumber lumber) {
        // check that the thickness does not differ more than EPSILON and 1.5
        // check that the width does not differ more than EPSILON and 3.5
        // check that the length does not differ more than EPSILON and
        // 96.0 inches
        // Tip: The constants in class Dimensional lumber document the expected
        // values for each dimension.
        // return a String that reports if the lumber meets the specifications
        // or if it does not, what dimension(s) are incorrect.

        // Note: If any of the dimensions are negative report
        // that the lumber could not be verified due to negative dimensions.

        // If lumber has negative values then it could not be verified
        if (lumber.getLength() < 0 || lumber.getThickness() < 0 || lumber.getWidth() < 0) {
            return "The lumber could not be verified due to negative dimensions.";
        }

        // calculate the tolerance values of each dimension
        double lengthToleranceValue = DimensionalLumber.EXPECTED_LENGTH * EPSILON;
        double thicknessToleranceValue = DimensionalLumber.EXPECTED_THICKNESS * EPSILON;
        double widthToleranceValue = DimensionalLumber.EXPECTED_WIDTH * EPSILON;

        // calculate the upper and lower bounds of each dimension
        double lengthUpperBound = DimensionalLumber.EXPECTED_LENGTH + lengthToleranceValue;
        double lengthLowerBound = DimensionalLumber.EXPECTED_LENGTH - lengthToleranceValue;
        double thicknessUpperBound = DimensionalLumber.EXPECTED_THICKNESS + thicknessToleranceValue;
        double thicknessLowerBound = DimensionalLumber.EXPECTED_THICKNESS - thicknessToleranceValue;
        double widthUpperBound = DimensionalLumber.EXPECTED_WIDTH + widthToleranceValue;
        double widthLowerBound = DimensionalLumber.EXPECTED_WIDTH - widthToleranceValue;

        // result string builder to append the results
        StringBuilder result = new StringBuilder();

        if (lumber.getLength() < lengthLowerBound || lumber.getLength() > lengthUpperBound) {
            // the length is beyond the lower and upper bound
            String message = String.format("The length of the lumber is beyond the tolerable values (%s - %s).",
                    lengthLowerBound, lengthUpperBound);
            result.append(message).append("\n");
        }

        if (lumber.getThickness() < thicknessLowerBound || lumber.getThickness() > thicknessUpperBound) {
            // the thickness is beyond the lower and upper bound
            String message = String.format("The thickness of the lumber is beyond the tolerable values (%s - %s).",
                    thicknessLowerBound, thicknessUpperBound);
            result.append(message).append("\n");
        }

        if (lumber.getWidth() < widthLowerBound || lumber.getWidth() > widthUpperBound) {
            // the width is beyond the lower and upper bound
            String message = String.format("The width of the lumber is beyond the tolerable values (%s - %s).",
                    widthLowerBound, widthUpperBound);
            result.append(message).append("\n");
        }

        if (!result.isEmpty()) {
            // one of the dimension exceeded the tolerance value(EPSILON) so return the message immediately.
            return result.toString().trim();
        }

        return "All lumber dimensions are valid";
    }
}
