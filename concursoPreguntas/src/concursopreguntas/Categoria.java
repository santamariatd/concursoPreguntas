package concursopreguntas;
/*
 * @author Daniel Santamaría Tavera
 */

/*
La clase Categoria es una lista tipo Pila, que contiene nodos con cada una de las preguntas que se crea cuando se invoca el método Insertar
*/

public class Categoria {
    class Pregunta{
        String texto;
        String A;
        String B;
        String C;
        String D;
        String correcta;
        Pregunta sig;

        public Pregunta(String texto, String A, String B, String C, String D, String correcta, Pregunta sig) {
            this.texto = texto;
            this.A = A;
            this.B = B;
            this.C = C;
            this.D = D;
            this.correcta = correcta;
            this.sig = sig;
        }
        
        public String getTexto() {
            return texto;
        }

        public String getA() {
            return A;
        }

        public String getB() {
            return B;
        }

        public String getC() {
            return C;
        }

        public String getD() {
            return D;
        }

        public String getCorrecta() {
            return correcta;
        }

        public Pregunta getSig() {
            return sig;
        }

        public void setTexto(String texto) {
            this.texto = texto;
        }

        public void setA(String A) {
            this.A = A;
        }

        public void setB(String B) {
            this.B = B;
        }

        public void setC(String C) {
            this.C = C;
        }

        public void setD(String D) {
            this.D = D;
        }

        public void setCorrecta(String correcta) {
            this.correcta = correcta;
        }

        public void setSig(Pregunta sig) {
            this.sig = sig;
        }
        
    }
    private Pregunta raiz;
    int puntaje;

    public int getPuntaje() {
        return puntaje;
    }
    
    public Categoria(int puntaje) {
        this.raiz = null;
        this.puntaje = puntaje;
    }
    
    void insertar(String text, String a, String b, String c, String d, String correct){
        Pregunta nuevo = new Pregunta(text,a,b,c,d,correct,null);
        if (raiz==null){
            raiz=nuevo;
        }else{
            nuevo.sig = raiz;
            raiz = nuevo;
        }
    }
    
    String retornar(int pos, String elemento){
        if (raiz==null){
            return "0";
        }
        else{
            String valor="0";
            Pregunta recorrido = raiz;
            int posicion=1;
            while (recorrido!=null){
                if(pos==posicion){
                    switch(elemento){
                        case "texto":
                            valor = recorrido.getTexto();
                            break;
                        case "a":
                            valor = recorrido.getA();
                            break;
                        case "b":
                            valor = recorrido.getB();
                            break;
                        case "c":
                            valor = recorrido.getC();
                            break;
                        case "d":
                            valor = recorrido.getD();
                            break;
                        case "correcta":
                            valor = recorrido.getCorrecta();
                            break;
                        default:
                            valor = "0";
                            break;
                    }
                    recorrido=null;
                }
                if (recorrido!=null){
                    recorrido = recorrido.getSig();
                }
                posicion++; 
            }
            return valor;
        }
    }
}
