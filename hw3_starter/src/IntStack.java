import java.util.Objects;

public class IntStack {
    private LinkedIntList data;
    public IntStack () {
        data = new LinkedIntList();
    }
    public IntStack(int... args) {
        data = new LinkedIntList(args);
    }
    public void push(int a) {
        //TODO: your code here
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public int pop() {
        //TODO: your code here
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public int peek_at(int idx) {
        //TODO: your code here
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof IntStack)) {
            return false;
        }
        LinkedIntList l1 = ((IntStack) other).data;
        LinkedIntList l2 = this.data;
        return l1.equals(l2);

    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }
}
