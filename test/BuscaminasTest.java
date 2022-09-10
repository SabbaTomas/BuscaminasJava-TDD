import org.junit.Assert;
import org.junit.Test;

public class BuscaminasTest {

    @Test
    public void crearTableroDeJuegoCienCasillas() {
        Integer filas = 10;
        Integer columnas = 10;
        Buscaminas partidaUno = new Buscaminas(filas, columnas);

        Assert.assertNotNull(partidaUno);
    }

    @Test
    public void colocarDiezMinasDeManeraAleatorea() {
        Integer filas = 10;
        Integer columnas = 10;
        Buscaminas partidaUno = new Buscaminas(filas, columnas);
        partidaUno.iniciarJuego();
        Integer ve = 10;
        Integer vo = partidaUno.contarMinas();
        Assert.assertEquals(ve, vo);
    }

    @Test
    public void siElegimosUnaCasillaOcupadaPorMinaQueDevuelvaTrue() {
        Integer filas = 10;
        Integer columnas = 10;
        Integer filaMina = 6;
        Integer columnaMina = 4;
        Integer filaSeleccionada = 6;
        Integer columnaSeleccionada = 4;
        Buscaminas partidaUno = new Buscaminas(filas, columnas);
        partidaUno.iniciarJuegoSeleccionandoMinas(filaMina, columnaMina);
        Boolean ve = partidaUno.seleccionarCasillaConMina(filaSeleccionada, columnaSeleccionada);
        Assert.assertTrue(ve);
    }

    @Test
    public void siElegimosUnaCasillaVaciaQueNosIndiqueFalse() {
        Integer filas = 10;
        Integer columnas = 10;
        Integer filaSeleccionada = 6;
        Integer columnaSeleccionada = 4;
        Buscaminas partidaUno = new Buscaminas(filas, columnas);
        partidaUno.iniciarJuegoConUnaSolaMina();
        Boolean ve = partidaUno.seleccionarCasillaVaciaYQueDevuelvaFalse(filaSeleccionada, columnaSeleccionada);
        Assert.assertFalse(ve);
    }

    @Test
    public void siLaCasillaEstaVaciaIndicarCuantasMinasHayAlrededor(){
        Integer filas = 10;
        Integer columnas = 10;
        Integer filaMina = 6;
        Integer columnaMina = 4;
        Integer filaSeleccionada = 6;
        Integer columnaSeleccionada = 5;
        Buscaminas partidaUno = new Buscaminas(filas, columnas);
        partidaUno.iniciarJuegoSeleccionandoMinas(filaMina, columnaMina);
        Integer vo = partidaUno.retornarCuantasMinasHayAlrededor(filaSeleccionada, columnaSeleccionada);
        Integer ve = 7;
        Assert.assertEquals(ve, vo);
    }
    
}
