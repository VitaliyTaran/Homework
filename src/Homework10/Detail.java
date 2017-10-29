package Homework10;

public class Detail {
    private DetailType type;
    private int counts;

    public Detail(DetailType detailType) {
    }

    public Detail(DetailType type, int counts) {
        this.type = type;
        this.counts = counts;
    }

    public DetailType getType() {
        return type;
    }

    public void setType(DetailType type) {
        this.type = type;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detail detail = (Detail) o;
        if (counts != detail.counts) return false;
        return type == detail.type;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + counts;
        return result;
    }

    @Override
    public String toString() {
        return type + " = " + counts;
    }
}