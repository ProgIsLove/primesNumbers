package evaluation;

public class PrimeNumber {

    public PrimeNumber() {
    }

    public boolean isPrime(Long n) {
        if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
