package com.edutilos.a3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edutilos on 12.05.18.
 */

/**
 * Diese Klasse wird von der Klasse LosslessJoinAnalyzer in der Methode helper()
 * aufgerufen.
 */
public class Utils {
    /**
     *
     * @param letter vom Typ String
     * @return vom Typ int
     */
    public static int getIndexForLetter(String letter) {
        return letter.toCharArray()[0]-65;
    }

    /**
     *
     * @param letters vom Typ UniqueList<String>
     * @return  vom Typ List<Integer>
     */
    public static List<Integer>  getIndicesForLetters(UniqueList<String> letters) {
        List<Integer> res = new ArrayList<>();
        for(int i=0; i< letters.size(); ++i) {
            String letter = letters.get(i);
            res.add(getIndexForLetter(letter));
        }
        return res;
    }
}
