package e.linyanan.studyapplication;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarriageSuggestionTest {
    @Test
    public void getSuggestion() {
        MarriageSuggestion marriageSuggestion = new MarriageSuggestion();

        String s = marriageSuggestion.getSuggetion("男", 25);
        assertEquals(s, "還不急");
        s = marriageSuggestion.getSuggetion("男", 30);
        assertEquals(s, "開始尋找對象");
        s = marriageSuggestion.getSuggetion("男", 34);
        assertEquals(s, "建議結婚");
        s = marriageSuggestion.getSuggetion("女", 24);
        assertEquals(s, "還不急");
        s = marriageSuggestion.getSuggetion("女", 29);
        assertEquals(s, "開始尋找對象");
        s = marriageSuggestion.getSuggetion("女", 31);
        assertEquals(s, "建議結婚");
    }
}

