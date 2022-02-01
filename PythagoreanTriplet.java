import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class PythagoreanTriplet {
    private int a;
    private int b;
    private int c;

    private PythagoreanTriplet() {
    }

    PythagoreanTriplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PythagoreanTriplet that = (PythagoreanTriplet) o;
        return a == that.a &&
                b == that.b &&
                c == that.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    static Builder makeTripletsList() {
        return new PythagoreanTriplet().new Builder();
    }

    public class Builder {
        private int sum;
        private int factorsLimit;

        private Builder() {
        }

        Builder withFactorsLessThanOrEqualTo(int factorsLimit) {
            if (factorsLimit < 1) {
                throw new IllegalArgumentException("FactorsLimit must be more than 0");
            }
            this.factorsLimit = factorsLimit;
            return this;
        }

        Builder thatSumTo(int sum) {
            if (sum < 6) {
                throw new IllegalArgumentException("Sum must be more than 5");
            }
            this.sum = sum;
            return this;
        }

        List<PythagoreanTriplet> build() {
            List<PythagoreanTriplet> result = new ArrayList<>();
            for (int a = 1; a <= Math.min(factorsLimit, sum / 3 - 1); a++) {
                for (int b = a + 1; b <= Math.min(factorsLimit, ((sum - 1) / 2)); b++) {
                    int c = sum - a - b;
                    if (a * a + b * b == c * c) {
                        result.add(new PythagoreanTriplet(a, b, c));
                    }
                }
            }
            return result;
        }
    }
}
