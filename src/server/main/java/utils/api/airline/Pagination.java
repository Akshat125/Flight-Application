package utils.api.airline;

public class Pagination{
    public int limit;
    public int offset;
    public int count;
    public int total;

    public Pagination(int limit, int offset, int count, int total) {
        this.limit = limit;
        this.offset = offset;
        this.count = count;
        this.total = total;
    }

    public Pagination() {
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}