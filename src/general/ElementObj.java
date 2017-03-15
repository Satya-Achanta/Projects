package general;

public class ElementObj {

	String element;
	int count;

	ElementObj() {
		this.count = 0;
	}

	ElementObj(String element, int count) {
		this.element = element;
		this.count = count;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
