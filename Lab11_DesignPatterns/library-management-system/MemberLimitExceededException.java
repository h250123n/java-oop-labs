public class MemberLimitExceededException extends Exception {

    private final String memberId;
    private final int limit;

    public MemberLimitExceededException(String memberId, int limit) {
        super("Member " + memberId + " already has the maximum of " + limit + " loans");
        this.memberId = memberId;
        this.limit = limit;
    }

    public String getMemberId() { return memberId; }
    public int getLimit() { return limit; }
}
