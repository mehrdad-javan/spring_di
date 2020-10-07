package se.lexicon.dao.sequencer;

/**
 * Created by Mehrdad Javan
 * Date: Oct, 2020
 */
public class AccountGenerator {

    private static int sequencer=1000;

    public static int nextAccountId(){
        return ++sequencer;
    }

    public static int getSequencer() {
        return sequencer;
    }
}
