package com.pixlog.detect;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Calculos {

    private ArrayList<Double> diametros = new ArrayList<>(), volumes = new ArrayList<>();
    private Integer especieArvore;
    private double metros2pes = 3.28084, bf2ft = 1.0/12.0, loglength;
    private String[][] gost2708_75_tabela01, gost2708_75_tabela02, gost2708_75_tabela03;

    public Calculos(){

    }

    public void setLoglength(double loglength) {
        this.loglength = loglength;
    }

    public void setDiametros(ArrayList<Double> diametros) {
        this.diametros = diametros;
    }

    public void setVolumes(ArrayList<Double> volumes) {
        this.volumes = volumes;
    }

    public int getContagem(){
        return diametros.size();
    }

    public double getSoma(){
        double soma = 0;

        for(int i = 0; i < getContagem(); i++)
            soma = soma + diametros.get(i);

        return round(soma,2);
    }

    public double getMedia(){
        return round(getSoma()/getContagem(),2);
    }

    public double getModa(){

        ArrayList<Double> vector = removeDuplicates(diametros);
        ArrayList<Integer> repeticoes = new ArrayList<>();

        int repeticao;
        double temp;
        for (int i = 0; i < vector.size(); i++){
            repeticao = 0;
            temp = vector.get(i);

            for (int j = i; j < getContagem(); j++)
                if (temp == diametros.get(j)) repeticao += 1;

            repeticoes.add(repeticao);
        }

        return round(vector.get(getPosMax(repeticoes)),2);
    }

    public double getMediana(){
        double mediana = 0;

        if (getContagem()%2 == 0){ //tamanho par, a mediana é a média dos dois valores do meio
            double v1 = diametros.get((getContagem()/2)-1),
                    v2 = diametros.get((getContagem()/2)+1);
            mediana = (v1+v2)/2;
        }else mediana = diametros.get((getContagem()+1)/2); //tamanho ímpar, a mediana é o valor do meio

        return round(mediana,2);
    }

    public double getVariancia(){
        double numerador = 0;

        for (int i = 0; i < getContagem(); i++)
            numerador += Math.pow(diametros.get(i)-getMedia(),2);

        return round(numerador/(getContagem()-1),2);
    }

    public double getDesvioPadrao(){
        return round(Math.sqrt(getVariancia()),2);
    }

    public double getErroPadrao(){
        return round(getDesvioPadrao()/Math.sqrt(getContagem()),2);
    }

    public double getCurtose(){
        double numerador = 0, denominador = 0;

        for (int i = 0; i < diametros.size(); i++){
            numerador = numerador + Math.pow((diametros.get(i)-getMedia()),4);
            denominador = denominador + Math.pow((diametros.get(i)-getMedia()),2);
        }

        return round(getContagem()*(numerador/Math.pow(denominador,2)),2);
    }

    public double getAssimetria(){
        return round((getMedia()-getModa())/getDesvioPadrao(),2);
    }

    public int getIntervalo(){
        double k = 1 + Math.log(getContagem())/Math.log(2); //regra de sturges
        double classes, dif = k - (int) k; //extrai a parte decimal
        if (dif >= 0.5) classes = Math.ceil(k); //arredonda para cima
        else classes = Math.floor(k); //arredonda para baixo

        return (int) classes;
    }

    public double getMinimo(){
        return round(Collections.min(diametros),2);
    }

    public double getMaximo(){
        return round(Collections.max(diametros),2);
    }

    public double getVolumeMedio(){
        return round(getVolumeTotal()/diametros.size(),2);
    }

    public double getVolumeMinimo(){
        ArrayList<Double> volumes = new ArrayList<>();

        for(int i = 0; i < diametros.size(); i++)
            volumes.add((Math.PI*Math.pow(cm2m(diametros.get(i)),2)*loglength)/4);

        return round(Collections.min(volumes),2);
    }

    public double getVolumeMaximo(){
        ArrayList<Double> volumes = new ArrayList<>();

        for(int i = 0; i < diametros.size(); i++)
            volumes.add((Math.PI*Math.pow(cm2m(diametros.get(i)),2)*loglength)/4);

        return round(Collections.max(volumes),2);
    }

    public double getVolumeTotal(){
        double volumeTotal = 0;

        for(int i = 0; i < diametros.size(); i++)
            volumeTotal = volumeTotal + (Math.PI*Math.pow(cm2m(diametros.get(i)),2)*loglength)/4;

        return round(volumeTotal,2);
    }

    public double getVolumeDesvioPadrao(){
        double numerador = 0;

        for(int i = 0; i < diametros.size(); i++)
            numerador = numerador + Math.pow(cm2m(diametros.get(i))-getVolumeMedio(),2);

        return round(Math.sqrt(numerador/(diametros.size()-1)),2);
    }

    public double getVolumeVariancia(){
        return round(Math.pow(getVolumeDesvioPadrao(),2),2);
    }

    private double cm2m(double cm){
        return cm/100;
    }

    private ArrayList<Double> removeDuplicates(ArrayList<Double> list) {
        ArrayList<Double> newList = new ArrayList<>(); // Create a new ArrayList

        for (Double element : list) // Traverse through the first list
            if (!newList.contains(element))//If this element is not present in newList then add it
                newList.add(element);

        return newList; // return the new list
    }

    private int getPosMax(ArrayList<Integer> arrayList){
        int index = 0;
        for (int i = 0; i < arrayList.size(); i++)
            if (arrayList.get(i) == Collections.max(arrayList)){
                index = i;
                break;
            }
        return index;
    }

    public void setEspecieArvore(Integer especieArvore) {
        this.especieArvore = especieArvore;
    }

    public void setGost2708_75(String[][] gost2708_75_tabela01,
                               String[][] gost2708_75_tabela02,
                               String[][] gost2708_75_tabela03) {
        this.gost2708_75_tabela01 = gost2708_75_tabela01;
        this.gost2708_75_tabela02 = gost2708_75_tabela02;
        this.gost2708_75_tabela03 = gost2708_75_tabela03;
    }

    public double pixels2m(double pixels, double fator){
        return pixels*fator;
    }

    public double pixels2cm(double pixels, double fator){
        return (pixels*fator)*100;
    }

    public double pixels2ft(double pixels, double fator){
        return pixels*fator;
    }

    public double pixels2pol(double pixels, double fator){
        return (pixels*fator)*12;
    }

    public double metro2pes(double metros){
        return metros*metros2pes;
    }

    public double pes2metros(double pes){
        return pes/metros2pes;
    }

    public double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);

        return (double) tmp / factor;
    }

    public ArrayList<Double> diamCalc(ArrayList<Double> r){
        ArrayList<Double> diametros = new ArrayList<>();
        for (int i = 0; i < r.size(); i++)
            diametros.add(2*r.get(i));
        return diametros;
    }

    public ArrayList<Double> volCalc(ArrayList<Double> raios, double comprimentoToras, double fatorPixels, int formulaVolume) {
        ArrayList<Double> volumes = new ArrayList<>();

        if (formulaVolume == 1){ //formula cilindrica

            for (int a = 0; a < raios.size(); a++){
                double volTemp = Math.PI*Math.pow(pixels2m(raios.get(a),fatorPixels),2)*comprimentoToras;
                volumes.add(volTemp);
            }

        }else if (formulaVolume == 2){ //escala JAS

            if (comprimentoToras < 6){ //toras menores que 6 m

                for (int a = 0; a < raios.size(); a++){
                    double diametro = 2*pixels2cm(raios.get(a),fatorPixels);
                    if (diametro < 14) //diametro menor que 14 cm
                        diametro = Math.floor(diametro);
                    else { //diametro igual ou maior que 14 cm
                        diametro = Math.floor(diametro);
                        for (;;){
                            if (diametro%2 != 0) diametro -= 1;
                            else break;
                        }
                    }

                    double volTemp = (Math.pow(diametro,2)*comprimentoToras)/10000;
                    volumes.add(volTemp);
                }

            }else { //toras igual ou maiores que 6 m

                for (int a = 0; a < raios.size(); a++){
                    double diametro = 2*pixels2cm(raios.get(a),fatorPixels);
                    if (diametro < 14) //diametro menor que 14 cm
                        diametro = Math.floor(diametro);
                    else { //diametro igual ou maior que 14 cm
                        diametro = Math.floor(diametro);
                        for (;;) {
                            if (diametro%2 != 0)diametro -= 1;
                            else break;
                        }
                    }

                    double volTemp = Math.pow(diametro+(Math.floor(comprimentoToras)-4)/2,2)*(comprimentoToras/10000);
                    volumes.add(volTemp);
                }
            }

        }else if (formulaVolume == 3){ //GOST 2708-05
            for (int a = 0; a <raios.size(); a++){
                double volTemp = Double.parseDouble(SearchForVolume(gost2708_75_tabela01,
                        pixels2cm(2*raios.get(a),fatorPixels),comprimentoToras));
                volumes.add(volTemp);
            }

        }else if (formulaVolume == 4){ //Regra de Toras Doyle
            for (int a = 0; a < raios.size(); a++){
                double volTemp = Math.pow(pixels2pol(2*raios.get(a),fatorPixels)-4,2)*comprimentoToras/16;
                volumes.add(volTemp);
            }

        }else if (formulaVolume == 5){ //Regra Internacional 1/4"

            if (comprimentoToras <= pes2metros(4)){ //toras menor que 4 ft.

                for (int a = 0; a < raios.size(); a++){
                    double volTemp = 0.199*Math.pow(pixels2pol(2*raios.get(a),fatorPixels),2)-(0.642*pixels2pol(2*raios.get(a),fatorPixels));
                    volumes.add(volTemp);
                }
            }else if (comprimentoToras > pes2metros(4) && comprimentoToras <= pes2metros(8)){

                for (int a = 0; a < raios.size(); a++){
                    double volTemp = 0.398*Math.pow(pixels2pol(2*raios.get(a),fatorPixels),2)-(1.086*pixels2pol(2*raios.get(a),fatorPixels)-0.27);
                    volumes.add(volTemp);
                }
            }else if (comprimentoToras > pes2metros(12) && comprimentoToras <= pes2metros(12)){

                for (int a = 0; a < raios.size(); a++){
                    double volTemp = 0.597*Math.pow(pixels2pol(2*raios.get(a),fatorPixels),2)-(1.330*pixels2pol(2*raios.get(a),fatorPixels)-0.72);
                    volumes.add(volTemp);
                }
            }else if (comprimentoToras > pes2metros(12) && comprimentoToras <= pes2metros(16)){

                for (int a = 0; a < raios.size(); a++){
                    double volTemp = 0.796*Math.pow(pixels2pol(2*raios.get(a),fatorPixels),2)-(1.375*pixels2pol(2*raios.get(a),fatorPixels)-1.23);
                    volumes.add(volTemp);
                }
            }else if (comprimentoToras > pes2metros(16) && comprimentoToras <= pes2metros(20)){

                for (int a = 0; a < raios.size(); a++){
                    double volTemp = 0.995*Math.pow(pixels2pol(2*raios.get(a),fatorPixels),2)-(1.221*pixels2pol(2*raios.get(a),fatorPixels)-1.72);
                    volumes.add(volTemp);
                }
            }

        }else if (formulaVolume == 6){ //Regra de toras Roy

            for (int a = 0; a < raios.size(); a++){
                double volTemp = Math.pow(pixels2pol(2*raios.get(a),fatorPixels)-1,2)*comprimentoToras/20;
                volumes.add(volTemp);
            }

        }else if (formulaVolume == 7){ //Scribner Decimal C
            double logLength = metro2pes(comprimentoToras);

            for (int a = 0; a < raios.size(); a++){
                double dib = pixels2pol(2*raios.get(a),fatorPixels);
                if ((dib - Math.floor(dib) <= 6)) //menor ou igual a 6"
                    dib = Math.floor(dib);
                else dib = Math.ceil(dib);

                double volTemp = Math.pow(dib-4, 2)*(logLength/16)*bf2ft;
                volumes.add(volTemp);
            }

        }else if (formulaVolume == 8){ //Regra de Medição Ontario

            for (int a = 0; a < raios.size(); a++){
                double volTemp = (0.55*Math.pow(pixels2pol(2*raios.get(a),fatorPixels),2)-1.2*pixels2pol(2*raios.get(a),fatorPixels))*(comprimentoToras/12);
                volumes.add(volTemp);
            }

        }else if (formulaVolume == 9){ //Sistema lituano

        }else if (formulaVolume == 10){ //Sistema lituano com casca

        }else if (formulaVolume == 11){ //Padrao letão

        }else if (formulaVolume == 12){ //formula A. Nilson

            double a1 = 0, a2 = 0, a3 = 0;

            if (especieArvore == 10){ //pinus
                a1 = 0.0799;
                a2 = 0.000146;
                a3 = 0.0411;
            }else if (especieArvore == 1){ //abeto
                a1 = 0.07995;
                a2 = 0.00016105;
                a3 = 0.04948;
            }else if (especieArvore == 11){ //vidoeiro
                a1 = 0.0783;
                a2 = 0.000236;
                a3 = 0.045;
            }

        }else if (formulaVolume == 13){ //Hoppus imperial

            for (int a = 0; a < raios.size(); a++){
                double volTemp = Math.pow(pixels2pol(raios.get(a),fatorPixels),2)*metro2pes(comprimentoToras)/144;
                volumes.add(volTemp);
            }

        }else if (formulaVolume == 14){ //hoppus metrico

            for (int a = 0; a < raios.size(); a++){
                double volTemp = Math.pow(pixels2cm(raios.get(a),fatorPixels),2)*comprimentoToras*0.00006185;
                volumes.add(volTemp);
            }

        }else if (formulaVolume == 15){ //padrao sul-africano

            //Softwood
            if (especieArvore == 9) //ex.: eucalipto
                for (int a = 0; a < raios.size(); a++){
                    double volTemp = Math.pow(pixels2cm(raios.get(a),fatorPixels)+(comprimentoToras/2),2)*Math.PI/40000*comprimentoToras;
                    volumes.add(volTemp);
                }

            //Hardwood
            else if (especieArvore == 10) //ex.: pinus
                for (int a = 0; a < raios.size(); a++){
                    double volTemp = Math.pow(pixels2cm(raios.get(a),fatorPixels)+0.4*comprimentoToras,2)*Math.PI/40000*comprimentoToras;
                    volumes.add(volTemp);
                }
        }

        return volumes;
    }

    public ArrayList<Double> diametros2pol(ArrayList<Double> diametrosPixels, Double fatorPixels){
        ArrayList<Double> diametrosPolegadas = new ArrayList<>();

        for (int i = 0; i < diametrosPixels.size(); i++)
            diametrosPolegadas.add(pixels2pol(diametrosPixels.get(i),fatorPixels));

        return diametrosPolegadas;
    }

    public ArrayList<Double> diametros2cm(ArrayList<Double> diametrosPixels, Double fatorPixels){
        ArrayList<Double> diametros_cm = new ArrayList<>();

        for (int i = 0; i < diametrosPixels.size(); i++)
            diametros_cm.add(pixels2cm(diametrosPixels.get(i),fatorPixels));

        return diametros_cm;
    }

    private String SearchForVolume(String[][] tabela, double diametro, double comprimento) {

        int rowcol[] = new int[]{tabela.length, tabela[0].length};

        //procura pelo comprimento mais proximo do informado
        ArrayList<Double> distComp = new ArrayList<>();
        for (int i = 1; i < rowcol[1]; i++){
            double dist = comprimento-Double.parseDouble(tabela[0][i]);
            distComp.add(dist);
        }

        //procura pelo diâmetro mais próximo do informado
        ArrayList<Double> distDiam = new ArrayList<>();
        for (int i = 1; i < rowcol[0]; i++){
            double dist = diametro-Double.parseDouble(tabela[i][0]);
            distDiam.add(dist);
        }

        //Adiciona-se 1 porque a busca começa no índice 1 e não no zero
        int rowNumber = distDiam.indexOf(Collections.min(JustAbsValues(distDiam)))+1;
        int colNumber = distComp.indexOf(Collections.min(JustAbsValues(distComp)))+1;

        return tabela[rowNumber][colNumber];
    }

    private ArrayList<Double> JustAbsValues(ArrayList<Double> arrayList) {
        ArrayList<Double> retorno = new ArrayList<>();

        for (int i = 0; i < arrayList.size(); i++)
            retorno.add(Math.abs(arrayList.get(i)));

        return retorno;
    }

    // POLYGON/CIRCLE
    public boolean polyCircle(ArrayList<double[]> vertices, double cx, double cy, Double r) {

        boolean circleInside = false;

        //Verifica se o centro do circulo está contido no polígono
        if (polygonPoint(vertices, cx,cy)){

            //Verifica se o círculo colide com uma aresta do polígono
            for (int current = 0; current < vertices.size(); current++){

                int next = current+1;
                if (next == vertices.size()) next = 0;

                double[] vc = vertices.get(current); // c for "current"
                double[] vn = vertices.get(next);       // n for "next"

                boolean collision = lineCircle(vc[0], vc[1], vn[0], vn[1], cx, cy, r);
                if (collision) circleInside = false;
                else circleInside = true;
            }
        }

        return circleInside;
    }

    // LINE/CIRCLE
    public boolean lineCircle(double x1, double y1, double x2, double y2, double cx, double cy, Double r) {

        boolean collision = false;

        // Is either end INSIDE the circle?
        // If so, return true immediately
        if (pointCircle(x1, y1, cx, cy, r) || pointCircle(x2, y2, cx, cy, r)) collision = true;

        // Get length of the line
        double len = Math.sqrt(Math.pow(x1 - x2,2) +Math.pow(y1 - y2,2));

        // Get dot product of the line and circle
        double dot = (( ((cx-x1)*(x2-x1)) + ((cy-y1)*(y2-y1)) ) / Math.pow(len,2));

        // Find the closest point on the line
        double closestX = x1 + (dot * (x2-x1));
        double closestY = y1 + (dot * (y2-y1));

        // Is this point actually on the line segment?
        // If so keep going, but if not, return false
        boolean onSegment = linePoint(x1,y1,x2,y2, closestX,closestY);
        if (!onSegment) collision = false;

        // Get distance to closest point
        float distance = (float) Math.sqrt(Math.pow(closestX - cx,2)+Math.pow(closestY - cy,2));

        // Is the circle on the line?
        if (distance <= r) collision = true;

        return collision;
    }

    // POINT/CIRCLE
    boolean pointCircle(double px, double py, double cx, double cy, Double r) {

        // get distance between the point and circle's center
        // using the Pythagorean Theorem
        double distX = px - cx;
        double distY = py - cy;
        double distance = Math.sqrt( Math.pow(distX,2) + Math.pow(distY,2));

        // if the distance is less than the circle's
        // radius the point is inside!
        if (distance <= r) {
            return true;
        }
        return false;
    }

    // LINE/POINT
    public boolean linePoint(double x1, double y1, double x2, double y2, double px, double py) {

        // get distance from the point to the two ends of the line
        float d1 = (float) Math.sqrt(Math.pow(px-x1,2)+Math.pow(py-y1,2));
        float d2 = (float) Math.sqrt(Math.pow(px-x2,2)+Math.pow(py-y2,2));

        // get the length of the line
        float lineLen = (float) Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));

        // since floats are so minutely accurate, add
        // a little buffer zone that will give collision
        float buffer = (float) 0.1;    // higher # = less accurate

        // if the two distances are equal to the line's
        // length, the point is on the line!
        // note we use the buffer here to give a range, rather
        // than one #
        if (d1+d2 >= lineLen-buffer && d1+d2 <= lineLen+buffer) {
            return true;
        }
        return false;
    }

    // POLYGON/POINT
    public boolean polygonPoint(ArrayList<double[]> vertices, double px, double py) {
        boolean collision = false;

        // go through each of the vertices, plus the next
        // vertex in the list
        int next = 0;
        for (int current=0; current<vertices.size(); current++) {

            // get next vertex in list
            // if we've hit the end, wrap around to 0
            next = current+1;
            if (next == vertices.size()) next = 0;

            // get the PVectors at our current position
            // this makes our if statement a little cleaner
            double[] vc = vertices.get(current);    // c for "current"
            double[] vn = vertices.get(next);       // n for "next"

            // compare position, flip 'collision' variable
            // back and forth
            if (((vc[1] > py && vn[1] < py) || (vc[1] < py && vn[1] > py)) &&
                    (px < (vn[0]-vc[0])*(py-vc[1]) / (vn[1]-vc[1])+vc[0])) {
                collision = !collision;
            }
        }
        return collision;
    }

    public double m32ft3(double m3) {
        return m3*35.3147;
    }

    public double ft32m3(double ft3) {
        return ft3/35.3147;
    }

    public String[] getVolumeFromCSV(String csv) {

        double volume = 0.0;
        String unit = "";

        try {
            CSVReader reader = new CSVReader(new FileReader(csv));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                try{
                    volume += Double.parseDouble(nextLine[2]);
                }catch (Exception e){
                    unit = nextLine[2].split("_")[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String[]{String.valueOf(round(volume,2)),unit};
    }
}
