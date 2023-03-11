public class LZ78 {

    List<String> diccionario;
    
    public LZ78() {
        diccionario = new ArrayList<String>();
        diccionario.add(null);
    }
    
    
    
    public List<Character> codificar(List<Integer> listaNumeros){
        String codif="";
        List<Character> listaC =new ArrayList<Character>();
        String letra="";
        boolean brea=false;
        int posicion=0;
        for(int i=0;i<=listaNumeros.size()+1;i++){
            int num=listaNumeros.get(i);
            letra+=(char)num;
    
            if(!diccionario.contains(letra)){   
                diccionario.add(letra);
                codif+=0;
                listaC.add('0');
                codif+=letra;
                char paso=letra.charAt(0);
                listaC.add(paso);
                letra="";
    
            }else{
    
                while(diccionario.contains(letra)){
    
                    i++;
    
                    if(i>=listaNumeros.size()){
    
                        brea=true;
    
    
                        if(!diccionario.contains(letra)){
                        listaC.add('0');
                        char paso2=letra.charAt(0);
                        listaC.add(paso2);
                        }else{
                            int index=diccionario.indexOf(letra);
                            String paso3=""+index;
                            for (int j = 0; j < paso3.length(); j++) {
                                listaC.add(paso3.charAt(j));
                            }
    
                        }
                        System.out.println("BREAK!");
                        break;
                    }
                    posicion=diccionario.indexOf(letra);
                    num=listaNumeros.get(i);
                    letra+=(char)num;
    
    
                }
    
                if(brea){
                    break;
                }
    
                i++;
    
                diccionario.add(letra);
                letra=""+letra.charAt(letra.length()-1);    
                codif+=posicion;
    
                String numero=""+posicion;
                for (int j = 0; j < numero.length(); j++) {
                    listaC.add(numero.charAt(j));
                }
    
    
                codif+=letra;   
                char paso=letra.charAt(0);
                listaC.add(paso);
    
                letra="";
                i--;
    
            }
        }
    
        System.out.println(codif);
    
        return listaC;
    }
    
    
    
    //public void decodificar(List<Integer>)
    
    
    public void codificacion(File textoPlano, File textoPlanoCodificado)
            throws IOException {
        BufferedReader bufLectura = new BufferedReader(new FileReader(
                textoPlano));
        BufferedWriter bufEscritura = new BufferedWriter(new FileWriter(
                textoPlanoCodificado));
    
        List<Integer> list = new ArrayList<Integer>();
        int i=0;
        int cosa=bufLectura.read();
        while(cosa!=-1) {
            list.add(cosa);
            i++;
            cosa=bufLectura.read();
        }
    
        List<Character> code=codificar(list);
    
        char[] codigo=new char[code.size()];
    
        for (int j = 0; j < code.size(); j++) {
            //System.out.print(j+":'"+code.get(j)+"'   ");
            codigo[j]=code.get(j);
    
            bufEscritura.write(codigo[j]);
        }
    
    
        System.out.println("FIN codificacion");
    
    
        bufEscritura.close();
    
    }
    
    public void decodificacion(File textoC, File textoD) throws IOException{
        BufferedReader bufLectura = new BufferedReader(new FileReader(textoC));
        BufferedWriter bufEscritura = new BufferedWriter(new FileWriter(textoD));
    
        List<Character> list = new ArrayList<Character>();
        int i=0;
        int cosa=bufLectura.read();
        while(cosa!=-1) {
            list.add((char)cosa);
            i++;
            cosa=bufLectura.read();
        }
    
        System.out.println(list);
    
        //List<Integer> list2 =decodificar(list);
        /*
        List<Character> code=codificar(list);
    
        char[] codigo=new char[code.size()];
        for (int j = 0; j < code.size()-1; j++) {
            codigo[j]=code.get(j);
    
            bufEscritura.write(codigo[j]);
        }
        System.out.println("FIN codificacion");
    
    
        bufEscritura.close();
        */
    }
    
    public static void main(String[] args) throws IOException {
        LZ78 lz78 = new LZ78();
        File textoPlano, textoPlanoCodificado, textoPlanoDecodificado;
    
        textoPlano = new File("C:/pruebas/T.txt");
        textoPlanoCodificado = new File("C:/pruebas/TOut.txt");
        textoPlanoDecodificado = new File("C:/pruebas/TDecOut.txt");
        lz78.codificacion(textoPlano, textoPlanoCodificado);
        lz78.decodificacion(textoPlanoCodificado, textoPlanoDecodificado);
    
        /*
         * textoPlano = new File("C:/pruebas/MobyDick.txt");
         * textoPlanoCodificado = new File("C:/pruebas/MobyDickOut.txt");
         * textoPlanoDecodificado = new File("C:/pruebas/MobyDickDecOut.txt");
         * lz78.codificacion(textoPlano, textoPlanoCodificado);
         * lz78.decodificacion(textoPlanoCodificado, textoPlanoDecodificado);
         * 
         * textoPlano = new File("C:/pruebas/Quixote.txt"); textoPlanoCodificado
         * = new File("C:/pruebas/QuixoteOut.txt"); textoPlanoDecodificado = new
         * File("C:/pruebas/QuixoteDecOut.txt"); lz78.codificacion(textoPlano,
         * textoPlanoCodificado); lz78.decodificacion(textoPlanoCodificado,
         * textoPlanoDecodificado);
         */
    } }
