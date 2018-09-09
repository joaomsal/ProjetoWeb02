package modelo;

public class Disciplina {

    private int periodo;
    private String tipo;
    private String cod;
    private String nome;
    private int crd;
    private String pq1;
    private String pq2;

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCrd() {
        return crd;
    }

    public void setCrd(int crd) {
        this.crd = crd;
    }

    public String getPq1() {
        return pq1;
    }

    public String getPq11() {
        if (this.pq1 == null) {
            return "-";
        } else {
            return pq1;
        }
    }

    public void setPq1(String pq1) {
        this.pq1 = pq1;
    }

    public String getPq2() {
        return pq2;
    }

    public String getPq22() {
          if (this.pq2 == null) {
            return "-";
        } else {
            return pq2;
        }
    }

    public void setPq2(String pq2) {
        this.pq2 = pq2;
    }

}
