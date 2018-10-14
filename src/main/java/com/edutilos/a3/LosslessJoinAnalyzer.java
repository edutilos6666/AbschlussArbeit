package com.edutilos.a3;

import java.util.List;

/**
 * Created by edutilos on 11.05.18.
 */
/**
 * Diese Klasse besteht ausschliesslich aus statischen Methoden . Hier wird bestimmt , ob die
 betrachtete Zerlegung verlustlost ist.
 */
public class LosslessJoinAnalyzer {

    /**
     *
     * @param matrix vom Typ Matrix
     * @param subset vom Typ UniqueList >Relation>
     */
    public static void testIfLosslessJoin(Matrix matrix, UniqueList<Relation> subset) {
        Relation rel = matrix.getRelation() ;
        UniqueList<FD> fds = matrix.getFds();
        if(!testIfRightSubset(matrix)) {
            System.out.println("Falsche Zerlegung");
            return ;
        }

        printMatrix(matrix);
//        System.out.println(matrix.toString());
        for(int i=0; i < matrix.getRowSize(); ++i) {
            for(int j=0; j< matrix.getColumnSize(); ++j) {
                Relation r = subset.get(i);
                if(r.containsLetterToIndex(j)) {
                    matrix.setAt(i,j, String.format("a%d", (j+1)));
                }
            }
        }

        printMatrix(matrix);

        boolean res = helper(matrix, true);
        if(res) {
            System.out.println("Zerlegung ist verlustlos.");
        } else {
            System.out.println("Zerlegung ist nicht verlustlos.");
        }

    }

    /**
     * Diese Methode ist eine rekursive Methode , und wird von testIfLosslessJoin() aufgerufen
     * @param m vom Typ Matrix
     * @param changed vom Typ boolean
     * @return Booleschen Wert: Wahr , wenn die Zerlegung verlustlos ist , falsch sonst
     */
    private static boolean helper(Matrix m, boolean changed)  {
        if(!changed) {
            return finalEvaluation(m);
        }
        changed = false;
        UniqueList<FD> fds = m.getFds();
        for(int i=0; i< fds.size(); ++i) {
            FD fd = fds.get(i);
            UniqueList<String> leftPart = fd.getLeftPart();
            UniqueList<String> rightPart = fd.getRightPart();
            List<Integer> leftIndices = Utils.getIndicesForLetters(leftPart);
            List<Integer> rightIndices = Utils.getIndicesForLetters(rightPart);
//            System.out.printf("leftIndices = %s\n", leftIndices.toString());
//            System.out.printf("rightIndices = %s\n", rightIndices.toString());
            for(int j= 0; j<m.getRowSize(); ++j) {
                for(int k=0; k< m.getRowSize(); ++k) {
                    if(k == j) continue;
                    boolean eq = true;
                    for(int a=0; a < leftIndices.size(); ++a) {
                        int index = leftIndices.get(a);
                        if(!m.getAt(j,index).equals(m.getAt(k,index))) {
                            eq = false;
                            break;
                        }
                    }

                    if(!eq) continue;
                    for(int a = 0; a <rightIndices.size(); ++a) {
                        int index = rightIndices.get(a);
                        if(m.getAt(j,index).substring(0,1).equals("a")) {
                            String oldValue = m.getAt(j,index);
                            m.setAt(k,index, m.getAt(j,index));
                            String newValue = m.getAt(j,index);
                            if(!oldValue.equals(newValue)) changed = true;
                        } else {
                            String oldValue = m.getAt(k,index);
                            m.setAt(j, index, m.getAt(k,index));
                            String newValue = m.getAt(k,index);
                            if(oldValue.equals(newValue)) changed = true;
                        }
                    }
                }
            }

            printMatrix(m);
            if(finalEvaluation(m)) return true;
        }


        return helper(m, changed);
    }

    /**
     * Diese Methode wird von der Methode helper() aufgerufen.
     * @param m vom Typ Matrix
     * @return Booleschen Wert: Wahr , wenn irgendeine Reihe nur aus "a*" besteht, sonst falsch
     */
    private static boolean finalEvaluation(Matrix m) {
        boolean res = true;
        for(int i=0; i< m.getRowSize(); ++i) {
            res = true;
            for(int j=0; j< m.getColumnSize(); ++j) {
                if(m.getAt(i, j).substring(0,1).equals("b")) {
                    res = false;
                    break;
                }
            }

            if(res) return res;
        }

        return res;
    }


    /**
     *
     * @param m vom Typ Matrix
     * @return vom Typ boolean
     */
    private static boolean testIfRightSubset(Matrix m) {
        Relation rel = m.getRelation();
        UniqueList<Relation> subset = m.getSubset();
        UniqueList<String> c = rel.getContent();
        for(int i=0; i< subset.size(); ++i) {
            Relation r = subset.get(i);
            UniqueList<String> c1 = r.getContent();
            if(c1.size() >= c.size()) return false;
            for(int j = 0 ; j  < c1.size(); ++j) {
                String str = c1.get(j);
                if(!c.contains(str)) return false;
            }
        }

        UniqueList<String> combined = new UniqueList<>();
        for(int i= 0; i < subset.size(); ++i) {
            Relation r = subset.get(i);
            for(int j=0; j< r.getContent().size(); ++j) {
                combined.add(r.getContent().get(j));
            }
        }

        for(int i=0; i< c.size(); ++i) {
            String str = c.get(i);
            if(!combined.contains(str)) return false;
        }

        for(int i = 0; i < combined.size(); ++i) {
            String str = combined.get(i);
            if(!c.contains(str)) return false;
        }

        return true;

    }

    /**
     * Diese Methode wird von der Methode testIfLosslessJoin() und helper() aufgerufen.
     * @param matrix vom Typ Matrix
     */
    public static void printMatrix(Matrix matrix) {
        final String space = " ";
        final String twoSpace = "  ";
        final String threeSpace = "   ";
        final String newline  ="\r\n";
        StringBuilder sb = new StringBuilder(twoSpace).append(threeSpace);
        Relation rel = matrix.getRelation();
        UniqueList<Relation> subset = matrix.getSubset();
        for(int i=0 ; i < rel.getContent().size(); ++i) {
            String str = rel.getContent().get(i);
            sb.append(str).append(twoSpace).append(twoSpace);
        }
        sb.append(newline);
        for(int i=0; i < matrix.getRowSize(); ++i) {
            sb.append(subset.get(i).getName()).append(threeSpace);
            List<List<String>> mContent = matrix.getContent();
            for(int j=0; j< matrix.getColumnSize(); ++j) {
                    String str = matrix.getAt(i, j);
                    sb.append(str);
                    if(str.length() == 2) sb.append(threeSpace);
                    else if(str.length() == 3) sb.append(twoSpace);
            }
            sb.append(newline);
        }

        System.out.println(sb.toString());
    }
}
