package com.edutilos.a3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by edutilos on 11.05.18.
 *
 */

/**
 * Diese Klasse enthaelt Relation R , Funktionale Abhaengigkeits FDs, und Zerlegung
 * R_1, R_2, ..., R_m
 */
public class Matrix {
    private Relation relation;
    private UniqueList<FD> fds = new UniqueList<>();
    private UniqueList<Relation> subset = new UniqueList<>();
    private List<List<String>> content = new ArrayList<>();

    /**
     * Konstruktor
     * @param relation vom Typ Relation
     * @param fds vom Typ UniqueList <FD>
     * @param subset vom Typ UniqueList <Relation>
     */
    public Matrix(Relation relation, UniqueList<FD> fds, UniqueList<Relation> subset) {
        this.relation = relation;
        for(int i=0; i< fds.size(); ++i) {
            this.fds.add(fds.get(i));
        }

        for(int i=0; i< subset.size(); ++i) {
            this.subset.add(subset.get(i));
        }

        List<String> temp;
        StringBuilder sb ;
//        System.out.printf("relation content size = %d\n", relation.getContent().size());
        for(int i=0; i< subset.size();++i) {
            temp = new ArrayList<>();
            for(int j= 0; j < relation.getContent().size(); ++j) {
                sb = new StringBuilder("b").append(i+1).append(j+1);
                temp.add(sb.toString());
            }
            content.add(temp);
        }
    }

    /**
     *
     * @param i vom Typ int (Index der Reihe)
     * @param j vom Typ int (Index der Spalte)
     * @return vom String
     */
    public String getAt(int i, int j) {
        return content.get(i).get(j);
    }

    /**
     *
     * @param i vom Typ int (Index der Reihe)
     * @param j vom Typ int (Index der Spalte)
     * @param str vom Typ String
     */
    public void setAt(int i, int j, String str) {
        content.get(i).set(j, str);
    }

    /**
     *
     * @return vom Typ List<List<String>>
     */
    public List<List<String>> getContent() {
        return content;
    }

    /**
     *
     * @param content vom Typ List<List<String>>
     */
    public void setContent(List<List<String>> content) {
        this.content = content;
    }

    /**
     *
     * @return vom Typ int
     */
    public int getRowSize() {
        return content.size();
    }

    /**
     *
     * @return vom Typ int
     */
    public int getColumnSize() {
        return content.get(0).size();
    }


    /**
     *
     * @return vom Typ Relation
     */
    public Relation getRelation() {
        return relation;
    }

    /**
     *
     * @param relation vom Typ Relation
     */
    public void setRelation(Relation relation) {
        this.relation = relation;
    }

    /**
     *
     * @return vom Typ UniqueList<FD>
     */
    public UniqueList<FD> getFds() {
        return fds;
    }

    public void setFds(UniqueList<FD> fds) {
        this.fds = new UniqueList<>();
        for(int i=0; i< fds.size(); ++i) {
            this.fds.add(fds.get(i));
        }
    }

    /**
     *
     * @return vom Typ UniqueList<Relation>
     */
    public UniqueList<Relation> getSubset() {
        return subset;
    }

    public void setSubset(UniqueList<Relation> subset) {
        this.subset = new UniqueList<>();
        for(int i=0; i< subset.size(); ++i) {
            this.subset.add(subset.get(i));
        }
    }

    /**
     *
     * @return vom Typ String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< getRowSize(); ++i) {
            for(int j=0; j< getColumnSize(); ++j) {
                sb.append(getAt(i, j)).append( " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Diese Methode wird von der Klasse Runner aufgerufen.
     */
    public void printPretty() {
        StringBuilder sb = new StringBuilder("<<Matrix>>").append("\n");
        sb.append(relation.toString()).append("\n");
        for(int i=0; i< subset.size(); ++i) {
            sb.append(subset.get(i).toString()).append("\n");
        }
        for(int i=0; i< fds.size(); ++i) {
            sb.append(fds.get(i).toString()).append("\n");
        }
        System.out.printf(sb.toString());
    }
}
