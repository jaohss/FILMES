import java.util.Scanner;
//Classe exception para valores inválidos
class ValorInvalidoException extends Exception{
    public ValorInvalidoException(String message){
        super(message);
    }
}

class Filme{
    //Definição dos atributos privados
    private String titulo;
    private int minutos;
    private Genero genero;

    //Construtor público
    public Filme(String titulo, int minutos, Genero genero){
        this.titulo=titulo;
        this.minutos=minutos;
        this.genero=genero;
    }

    //Método getter para o título
    public String getTitulo(){
        return titulo;
    }

    //Método setter para o título e a verificação se o título está vazio ou não usando a condicional if, que caso o título seja null(nulo) ou usa isEmpty para verificar se a String está vazia ou não, a trim() é usado para remover algum espaço branco caso a String tenha
    public void setTitulo(String titulo) throws Exception{
        if(titulo== null || titulo.trim().isEmpty()){
            throw new Exception("O título não pode estar vazio");
        }
        else{
            this.titulo=titulo;
        }
        
    }

    //Método getter para os Minutos
    public int getMinutos() {
        return minutos;
    }

    //Método setter para os Minutos e verificação para que não seja menor que 0
    public void setMinutos(int minutos) throws ValorInvalidoException {
        if(minutos<=0){
            throw new ValorInvalidoException("A duração do filme não pode ser menor que 0.");
        }
        else{
            this.minutos = minutos;
        }
        
    }
    
    //Método getter para Genero
    public Genero getGenero() {
        return genero;
    }

    /*Método setter para genero, que também faz a verificação se o genero é Comédia ou romance ou terror, a função equalsIgnoreCase vai ignorar a forma que o genero for escrito, ou seja, se for escrito "Comedia" ou "comedia" ou "COMEDIA", o programa vai aceitar de qualquer jeito. E depois, vai retornar o nome do gênero em letra maiuscula usando a função toUpperCase(). */

    public void setGenero(String genero) throws ValorInvalidoException {
        if(genero.equalsIgnoreCase("COMEDIA") ||genero.equalsIgnoreCase("TERROR") ||genero.equalsIgnoreCase("ROMANCE") ){
            this.genero=Genero.valueOf(genero.toUpperCase());
        }
        //Caso o genero digitado não nenhum dos mencionados, será exibido a mensagem de erro
        else{
            throw new ValorInvalidoException("Gênero inválido. Tente Romance, Terror ou Comédia");
        }
    }

    //enum contendo defição para cada gênero
    enum Genero{
        //Definição das constantes do enum com seus valores
        COMEDIA("Comedia"), ROMANCE("Romance"), TERROR("Terror");

        //Definição da constante
        private String categoria;

        //Construtor
        Genero(String categoria){
            this.categoria=categoria;
        }

        //Método getter para categoria
        public String getCategoria(){
            return this.categoria;
        }
    }

    //Código principal
    public static void main(String[] args) {
        //Instrução try na tentativa de executar o código principal
        try{

            //Instanciando objetos
            Scanner scn = new Scanner(System.in);
            Filme f1 = new Filme(null, 0, null);

            //Entrada de dados
            System.out.println("Digite o título do filme: ");
            f1.setTitulo(scn.nextLine());

            System.out.println("Digite a duração do filme: ");
            f1.setMinutos(scn.nextInt()) ;
            scn.nextLine();

            System.out.println("Digite o gênero do filme: ");
            f1.setGenero(scn.nextLine());

            System.out.println();

            //Saída de dados
            System.out.println("Título: "+f1.getTitulo());
            System.out.println("Duração: "+f1.getMinutos()+" minutos");
            System.out.println("Genero: "+f1.getGenero().getCategoria());

            scn.close();
        }

        //Bloco catch caso algum dado anterior venha a falhar
        catch(Exception e){
            System.err.println("Erro:"+ e.getMessage());
        }
        

        
    }
}

