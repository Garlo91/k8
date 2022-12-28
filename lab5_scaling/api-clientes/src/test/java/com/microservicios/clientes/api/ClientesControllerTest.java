package com.microservicios.clientes.api;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.JsonFieldType.NUMBER;
import static org.springframework.restdocs.payload.JsonFieldType.STRING;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservicios.clientes.ClientesServiceApplication;
import com.microservicios.clientes.modelo.ClienteBean;

/**
 * <b>ClientesControllerTest.java</b>
 *
 * @author Jovani AC
 * @version 1.0
 * @ultimaModificacion 3 marzo. 2018 12:39:12
 */

@RunWith(SpringRunner.class) //runner configuration de spring
@ContextConfiguration(classes = ClientesServiceApplication.class)
@SpringBootTest // infraestructura de pruebas
@AutoConfigureMockMvc // spring rest docs, crea mockMvc
@AutoConfigureRestDocs(outputDir = "build/snippets") //escribe los resultados en el directorio indicado
public class ClientesControllerTest {
  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private ObjectMapper objectMapper;
  private List<FieldDescriptor> CLIENTE_RESPONSE_DESCRIPTORS;
  private List<FieldDescriptor> CLIENTE_REQUEST_DESCRIPTORS;
  private ClienteBean clienteBean;
  private Logger log = Logger.getLogger(ClientesControllerTest.class);

  @Before
  public void init() {

    CLIENTE_RESPONSE_DESCRIPTORS = Stream.of(
      fieldWithPath("folioCliente")
        .type(STRING)
        .description("El identificador del cliente generado"),
      fieldWithPath("nombre")
        .type(STRING)
        .description("Nombre del cliente"),
      fieldWithPath("apellidoPaterno")
        .type(STRING)
        .description("Apellido paterno del cliente"),
      fieldWithPath("apellidoMaterno")
        .type(STRING)
        .description("Apellido materno del cliente"),
      fieldWithPath("email")
        .type(STRING)
        .description("Email del cliente"),
      fieldWithPath("direccion")
        .type(STRING)
        .description("Direccion del cliente"),
      fieldWithPath("genero")
        .type(STRING)
        .description("Genero del cliente"),
      fieldWithPath("edad")
        .type(NUMBER)
        .description("Edad actual del cliente"))
      .collect(Collectors.toList());

    CLIENTE_REQUEST_DESCRIPTORS = Stream.of(
      fieldWithPath("folioCliente")
        .type(STRING)
        .description("El identificador del cliente generado"),
      fieldWithPath("nombre")
        .type(STRING)
        .description("Nombre del cliente"),
      fieldWithPath("apellidoPaterno")
        .type(STRING)
        .description("Apellido paterno del cliente"),
      fieldWithPath("apellidoMaterno")
        .type(STRING)
        .description("Apellido materno del cliente"),
      fieldWithPath("email")
        .type(STRING)
        .description("Email del cliente"),
      fieldWithPath("direccion")
        .type(STRING)
        .description("Direccion del cliente"),
      fieldWithPath("email")
        .type(STRING)
        .description("Email del cliente"),
      fieldWithPath("genero")
        .type(STRING)
        .description("Genero del cliente"),
      fieldWithPath("edad")
        .type(NUMBER)
        .description("Edad actual del cliente")
    ).collect(Collectors.toList());

    clienteBean = new ClienteBean();
    clienteBean.setFolioCliente("999");
    clienteBean.setNombre("Jovani");
    clienteBean.setApellidoPaterno("Arzate");
    clienteBean.setApellidoMaterno("Cabrera");
    clienteBean.setEmail("jovaniac@gmail.com");
    clienteBean.setDireccion("azaleas temixco Mor");
    clienteBean.setGenero("masculino");
    clienteBean.setEdad(26);

  }

  @Test
  public void permiteCrearClientes() throws Exception {

    String json = objectMapper.writeValueAsString(clienteBean);

    ResultActions result = mockMvc.perform(post("/v1/clientes")
                    .contentType(APPLICATION_JSON)
                    .content(json)
    );

    result.andExpect(status().isCreated())
            .andExpect(
                    jsonPath("folioCliente").isNotEmpty())
            .andExpect(
                    jsonPath("nombre").value(clienteBean.getNombre()))
            .andExpect(
                    jsonPath("email").value(clienteBean.getEmail()))
            .andDo(document("v1-cliente/create",
                     preprocessRequest(prettyPrint()), //formatea request y response
                    requestFields(CLIENTE_REQUEST_DESCRIPTORS) //tabla de request
            ));
  }


  @Test
  public void permiteObtenerUnCliente() throws Exception {

    log.info("Se creo al cliente {}: " +clienteBean);

    mockMvc.perform(get("/v1/clientes/" + clienteBean.getFolioCliente()))
            .andDo(print())
            .andExpect(
                    status().isOk())
            .andExpect(
                    jsonPath("folioCliente").value(clienteBean.getFolioCliente()))
            .andDo(document("v1-cliente/get",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint())));
  }


  @Test
  public void permiteFallarCuandoBuscamosClientesNoExistentes() throws Exception {
    String folioNoValido = "23894238237";
    mockMvc.perform(get("/v1/clientes/" + folioNoValido))
            .andDo(print())
            .andExpect(
                    status().isNotFound())
            .andExpect(
                    jsonPath("folioCliente").value(folioNoValido))
            .andDo(document("v1-cliente/getNotFound",
                    preprocessRequest(prettyPrint())));
  }



  @Ignore
  @Test
  public void shouldDeleteClient() throws Exception {
    clienteBean.setEmail("aborrarlo@ff.com");

    log.info("Se creo al cliente {}: "+ clienteBean);

    mockMvc.perform(delete("/v1/clientes/" + clienteBean.getFolioCliente()))
      .andDo(print())
      .andExpect(
        status().isNoContent())
      .andDo(document("v1-cliente/deleteClient"));
  }

  @Ignore
  @Test
  public void shouldFailWhenDeleteAMissingClient() throws Exception {
    String missingId = "fjhgfjhdsg";

    mockMvc.perform(delete("/v1/clientes/" + missingId))
      .andDo(print())
      .andExpect(
        status().isNotFound())

      .andDo(document("v1-cliente/deleteClient-fail-not-found"));
  }
}
