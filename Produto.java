import java.util.Scanner;

public class Produto {

    public String codigo;
    public String nome;
    public int quantidade;
    public String tipo;
    public double valorDeCompra;
    public double valorDeVenda;
    
    public Produto(String _codigo, String _nome, int _quantidade, String _tipo, double _valorDeCompra, double _valorDeVenda) {
        this.codigo = _codigo;
        this.nome = _nome;
        this.quantidade = _quantidade;
        this.tipo = _tipo;
        this.valorDeCompra = _valorDeCompra;
        this.valorDeVenda = _valorDeVenda;
    }

    /*

     Para registro o produto vai precisar de um código, nome, quantidade e tipo, pois pode ser livro
     ou consumível.

     Valor de compra e valor de venda são atributos necessários para calcular o lucro do dono do estabelecimento
     e para o controle do fluxo de caixa.

     Futuramente será adicionado informações específicas para cada tipo de produto que for selecionado no atributo
     "tipo".

     Necessária a criação de uma arraylist para registro
   */

    // public void registroProduto(){
    //     Scanner scanner = new Scanner(System.in);
    //     System.out.println("-----------------");
    //     System.out.println("Digite o código do produto: ");
    //     String Codigo = scanner.nextLine();
    //     System.out.println("Digite o tipo do produto: ");
    //     String Tipo = scanner.nextLine();
    //     System.out.println("Digite o nome do produto: ");
    //     String Nome = scanner.nextLine();
    //     setNome(Nome);
    //     System.out.println("Digite a quantidade que vai ser armazenada: ");
    //     int Quantidade = scanner.nextInt();
    //     setQuantidade(Quantidade);
    //     System.out.println("Digite o valor de compra produto: ");
    //     double valorC = scanner.nextDouble();
    //     setValorDeCompra(valorC);
    //     System.out.println("Digite o valor de venda produto: ");
    //     double valorV = scanner.nextDouble();
    //     setValorDeVenda(valorV);

    // }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public double getValorDeCompra() {
        return valorDeCompra;
    }

    public void setValorDeCompra(double valorDeCompra) {
        this.valorDeCompra = valorDeCompra;
    }

    public double getValorDeVenda() {
        return valorDeVenda;
    }

    public void setValorDeVenda(double valorDeVenda) {
        this.valorDeVenda = valorDeVenda;
    }
}
