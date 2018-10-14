package com.edutilos.a3;



/**
 * Created by edutilos on 11.05.18.
 */

/**
 * Diese Klasse repraesentiert Relationschema R , oder Teilschema R_1, R_2 , ... ,R_m
 */
public class Relation {
    private String name;
    private UniqueList<String> content = new UniqueList<>();

    /**
     * Konstruktor
     * @param name vom Typ String
     * @param content vom Typ UniqueList<String>
     */
    public Relation(String name, UniqueList<String> content) {
        this.name = name;
        this.content = content;
    }

    /**
     *
     * @return vom String
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name vom Typ String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param content vom Typ UniqueList<String>
     */
    public void setContent(UniqueList<String> content) {
        this.content = content;
    }

    /**
     *
     * @return vom Typ UniqueList<String>
     */
    public UniqueList<String> getContent() {
        return content;
    }

    /**
     *
     * @param index vom Typ int
     * @return vom Typ boolean
     */
    public boolean containsLetterToIndex(int index) {
        String str = Character.toString((char)(index+65))+ "";
//        System.out.println(str);
        return getContent().contains(str);
    }

    /**
     *
     * @return vom Typ String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name).append("(");
        for(int i=0; i< content.size(); ++i) {
            String str = content.get(i);
            sb.append(str).append(",");
        }
        sb.replace(sb.length()-1, sb.length(), ")");
        return sb.toString();
    }
}
