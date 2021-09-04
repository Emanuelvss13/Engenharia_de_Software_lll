/* Refatoração */

/* Motivo */
|
public class TesteSoma {
    public static void main(String[] args) {
        Soma so = new Soma();
        so.n1 = 5;
        so.n2 = 9;

        System.out.println(so.obterSoma());
    }
}

/* Antes */

public class Soma {
    int n1, n2;

    int obterSoma() {
        return n1 + n2;
    }
}

/* Depois */

public class Soma {
    private int n1, n2;

    public Soma(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    int obterSoma() {
        return n1 + n2;
    }

}

/* Motivo */

public class TesteDesconto {
    public static void main(String[] args) {
        Desconto desc = new Desconto();

        desc.valorOriginal = 120;
        desc.desconto = 10;

        System.out.println(desc.calcula());
    }

}

/* Antes */

public class Desconto {
    double valorOriginal, valorCalculado, desconto;

    double calcula() {
        return valorCalculado = valorOriginal * (1 - desconto / 100);
    }
}

/* Depois */

public class Desconto {
    private double valorOriginal, valorCalculado, desconto;

    public Desconto(double valorOriginal, double valorCalculado, double desconto) {
        this.valorOriginal = valorOriginal;
        this.valorCalculado = valorCalculado;
        this.desconto = desconto;
    }

    double calcula() {
        return valorCalculado = valorOriginal * (1 - desconto / 100);
    }

}

/* Antes */

public class Equipamento {
    boolean a = false;

    boolean liga() {
        if (a == true) {
            return a;
        } else {
            return a = true;
        }

    }

    boolean desliga() {
        if (a == false) {
            return a;
        }
        return a = false;
    }

    boolean inverte() {
        if (a == true) {
            return a = false;
        } else {
            return a = true;
        }
    }

    boolean estaLigado() {
        return a = true;
    }
}

/* Depois */

public class Equipamento {
    private boolean a = false;

    public boolean getA() {
        return a;
    }

    public void setA(boolean a) {
        this.a = a;
    }

    boolean liga() {
        if (a == true) {
            return a;
        }
        return a = true;
    }

    boolean desliga() {
        if (a == false) {
            return a;
        }
        return a = false;
    }

    boolean inverte() {
        this.a = !a;
        return a;
    }

    boolean estaLigado() {
        return a == true;
    }

}

/* Antes */

public class Conta {
    String numero;
    private double saldo;

    Conta(String numero, double valor) {
        this.numero = numero;
        this.saldo = valor;
    }

    void sacar(double valor) {
        if (saldo < valor) {
            System.out.println("False");
        } else {
            saldo = saldo - valor;
            System.out.println("True");
        }

    }

    void depositar(double valor) {
        saldo = saldo + valor;
    }

    double consultarSaldo() {
        return saldo;
    }

    void transferir(Conta destino, double valor) {
        // saldo = saldo - valor;
        // destino.saldo = destino.saldo + valor;
        if (valor > this.saldo) {
            System.out.println("False");
        } else {
            this.sacar(valor);
            destino.depositar(valor);
        }

    }

}

/* Depois */

public class Conta {
    String numero;
    private double saldo;

    Conta(String numero, double valor) {
        this.numero = numero;
        this.saldo = valor;
    }

    void sacar(double valor) {
        if (saldo < valor) {
            System.out.println("False");
        }

        saldo = saldo - valor;
        System.out.println("True");

    }

    void depositar(double valor) {
        saldo = saldo + valor;
    }

    double consultarSaldo() {
        return saldo;
    }

    void transferir(Conta destino, double valor) {

        if (valor > this.saldo) {
            System.out.println("False");
        }

        this.sacar(valor);
        destino.depositar(valor);
    }

}

    /* Fail Firts */

    /* Antes */

    /*
     * Link:
     * https://github.com/Emanuelvss13/ifpi-ads-algoritimos2020/blob/master/POO_07/
     * ProjetoPOO_07/ProjetoPOO_07/src/br/edu/ifpi/poo/banco/cadastros/Banco.java
     */

    public void inserir(Conta c) {
        if (indice < contas.length) {
            contas[indice] = c;
            indice++;
        } else {
            throw new AplicacaoException("Limite de contas atingido!");
        }
    }

    /* Depois */

    public void inserir(Conta c) {
        if (indice > contas.length) {
            throw new AplicacaoException("Limite de contas atingido!");
        }

        contas[indice] = c;
        indice++;
    }

    /* Tell, don't ask! */

    /* Antes */

    public void inserir(Conta c) {
        if (indice < contas.length) {
            contas[indice] = c;
            indice++;
        } else {
            throw new AplicacaoException("Limite de contas atingido!");
        }
    }

    /* Depois */

public void inserir(String numero, double valor) {

    Conta novaConta = new Conta(numero, valor);

    if (indice > contas.length) {
        throw new AplicacaoException("Limite de contas atingido!");
    } 

    contas[indice] = novaConta;
    indice++;
}
