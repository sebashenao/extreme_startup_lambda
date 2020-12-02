package com.serverless;
import static org.assertj.core.api.Assertions.*;
import org.junit.Test;


public class ResponderModelTest {

    //https://u1qc1qjhlk.execute-api.us-east-1.amazonaws.com/dev/responding

    ResponderModel responder = new ResponderModel();

    @Test
    public void cuandoLaPreguntaSeaVaciaRetornaDCA() {
        //Arrange
        String pregunta = "";

        //Act
        String respuesta = responder.answer(pregunta);

        //Assert
        assertThat(respuesta).isEqualTo("dca");
    }
    @Test
    public void devolverNombre() {
        //Arrange
        String pregunta = ".*what is the sum of 5 and 10";

        //Act
        String respuesta = responder.answer(pregunta);

        //Assert
        assertThat(respuesta).isEqualTo("14");
    }
}
