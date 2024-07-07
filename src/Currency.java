public class Currency {

	private int numCents;

	public Currency() {
		numCents = 0;
	}

	public Currency(int cents) {
		numCents = cents;
	}

	public int getValue() {
		return numCents;
	}

	public Currency add (Currency rhs) {
        this.numCents+=rhs.getValue();
        return this;

    }

    public Currency subtract (Currency rhs) {
        this.numCents-=rhs.getValue();
        return this;
    }
	public String toString() {
		return "New Balance: $" + numCents/100 + "." + numCents%100 + "\n";
	}

}
