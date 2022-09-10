public class Buscaminas {

    private Boolean tablero[][];

    public Buscaminas(Integer filas, Integer columnas) {
        this.tablero = new Boolean[filas][columnas];
    }

    public void iniciarJuego() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                this.tablero[i][j] = false;
            }
        }
        Integer numeroAleatorioUno;
        Integer numeroAleatorioDos;
        for (int i = 0; i < 10; i++) {
            numeroAleatorioUno = (int) (Math.random() * 9 + 1);
            numeroAleatorioDos = (int) (Math.random() * 9 + 1);
            this.tablero[numeroAleatorioUno][numeroAleatorioDos] = true;
        }
    }

    public Integer contarMinas() {
        Integer contador = 0;

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == true) {
                    contador++;
                }
            }
        }

        return contador;
    }

    public void iniciarJuegoSeleccionandoMinas(Integer filaMina, Integer columnaMina) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                this.tablero[i][j] = false;
            }
        }
        this.tablero[filaMina][columnaMina] = true;
    }

    public Boolean seleccionarCasillaConMina(Integer filaSeleccionada, Integer columnaSeleccionada) {
        Boolean casillaConMina = false;
        if (this.tablero[filaSeleccionada][columnaSeleccionada]) {
            casillaConMina = true;
        }
        ;
        return casillaConMina;
    }

    public void iniciarJuegoConUnaSolaMina() {

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                this.tablero[i][j] = false;
            }
        }

        Integer numeroAleatorioUno = (int) (Math.random() * 9 + 1);
        Integer numeroAleatorioDos = (int) (Math.random() * 9 + 1);
        this.tablero[numeroAleatorioUno][numeroAleatorioDos] = true;

    }

    public Boolean seleccionarCasillaVaciaYQueDevuelvaFalse(Integer filaSeleccionada, Integer columnaSeleccionada) {
        Boolean casillaVacia = true;
        if (!this.tablero[filaSeleccionada][columnaSeleccionada]) {
            casillaVacia = false;
        }
        ;
        return casillaVacia;
    }

    public Integer retornarCuantasMinasHayAlrededor(Integer filaSeleccionada, Integer columnaSeleccionada) {
        Integer cantidadDeMinasAlrededor = 0;
        if (!seleccionarCasillaVaciaYQueDevuelvaFalse(filaSeleccionada, columnaSeleccionada)) {
            Integer filaMas = filaSeleccionada + 1;
            Integer filaMenos = filaSeleccionada - 1;
            Integer columnaMas = columnaSeleccionada + 1;
            Integer columnaMenos = columnaSeleccionada - 1;

            if (!this.tablero[filaMas][columnaSeleccionada]) {
                cantidadDeMinasAlrededor++;
            }
            if (!this.tablero[filaMenos][columnaSeleccionada]) {
                cantidadDeMinasAlrededor++;
            }
            if (!this.tablero[filaSeleccionada][columnaMenos]) {
                cantidadDeMinasAlrededor++;
            }
            if (!this.tablero[filaMas][columnaMenos]) {
                cantidadDeMinasAlrededor++;
            }
            if (!this.tablero[filaMenos][columnaMenos]) {
                cantidadDeMinasAlrededor++;
            }
            if (!this.tablero[filaMenos][columnaMas]) {
                cantidadDeMinasAlrededor++;
            }
            if (!this.tablero[filaMas][columnaMas]) {
                cantidadDeMinasAlrededor++;
            }
            if (!this.tablero[filaSeleccionada][columnaMas]) {
                cantidadDeMinasAlrededor++;
            }
        }
        return cantidadDeMinasAlrededor;
    }

}
