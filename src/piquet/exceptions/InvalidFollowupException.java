package piquet.exceptions;

/**
 * Created by jenko on 26.02.16.
 */
public class InvalidFollowupException extends InvalidException {

    protected Integer base;
    protected Integer followup;

    public InvalidFollowupException(Integer base, Integer followup) {
        this.base = base;
        this.followup = followup;
    }

    public Integer getBase() {
        return this.base;
    }

    public Integer getFollowup() {
        return this.followup;
    }

}
