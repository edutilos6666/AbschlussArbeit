package com.edutilos.a3;




/**
 * Created by edutilos on 11.05.18.
 */

/*
 Diese Klasse repraesentiert Funktionale Abhaengigkeiten (Functional dependencies)
 */
public class FD {
    //die Elemente bis "->"
    private UniqueList<String> leftPart = new UniqueList<>();
    //die Elemente nach "->"
    private UniqueList<String> rightPart = new UniqueList<>();
    private String name;

    /**
     * Konstruktor
     * @param name vom Type String
     * @param content vom Type String
     */
    public FD(String name, String content) {
        this.name = name;
        try {
            String[] str = content.split("->");
            if(str.length != 2) throw new Exception("malformed content");
            for(char ch: str[0].toCharArray()) {
                leftPart.add(ch+"");
            }
            for(char ch: str[1].toCharArray()) {
                rightPart.add(ch+"");
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Konstruktor
     * @param name vom Typ name
     * @param leftPart vom Typ UniqueList <String>
     * @param rightPart vom Typ UniqueList <String>
     */
    public FD(String name, UniqueList<String> leftPart , UniqueList<String> rightPart) {
        this.name = name;
        for(int i=0; i< leftPart.size(); ++i) {
            this.leftPart.add(leftPart.get(i));
        }

        for(int i=0; i< rightPart.size(); ++i) {
            this.rightPart.add(rightPart.get(i));
        }
    }


    //getter und setter
    /**
     *
     * @return vom Typ vom Typ UniqueList <String>
     */
    public UniqueList<String> getLeftPart() {
        return leftPart;
    }

    /**
     *
     * @param leftPart vom Typ vom Typ UniqueList <String>
     */
    public void setLeftPart(UniqueList<String> leftPart) {
        this.leftPart = new UniqueList<>();
        for(int i=0; i< leftPart.size(); ++i) {
            this.leftPart.add(leftPart.get(i));
        }
    }

    /**
     * @return vom Typ vom Typ UniqueList <String>
     */
    public UniqueList<String> getRightPart() {
        return rightPart;
    }

    public void setRightPart(UniqueList<String> rightPart) {
        this.rightPart = new UniqueList<>();
        for(int i=0; i< rightPart.size(); ++i) {
            this.rightPart.add(rightPart.get(i));
        }
    }

    /**
     *
     * @return vom Typ String
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
     * @return vom Typ String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name).append(":");
        for(int i=0 ; i< leftPart.size(); ++i) {
            String str = leftPart.get(i);
            sb.append(str);
        }
        sb.append("->");
        for(int i=0 ; i< rightPart.size(); ++i) {
            String str = rightPart.get(i);
            sb.append(str);
        }
        return sb.toString();
    }
}
