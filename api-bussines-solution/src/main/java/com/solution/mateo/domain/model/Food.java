package com.solution.mateo.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.Objects;

/**
 * Food
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Food   {
  @JsonProperty("idAlimento")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  private String idAlimento ;

  @JsonProperty("name")
  private String name;

  @JsonProperty("tipo")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  private Long tipo;

  @JsonProperty("flagEli")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  private Long flagEli;

  @JsonProperty("fechaInsert")
  @JsonInclude(JsonInclude.Include.NON_EMPTY)  // Exclude from JSON if absent
  private Date fechaInsert;

  @JsonProperty("usuarioInsert")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  private String usuarioInsert;

  @JsonProperty("fechaUpdate")
  @JsonInclude(JsonInclude.Include.NON_NULL)  // Exclude from JSON if absent
  private Date fechaUpdate;

  @JsonProperty("usuarioUpdate")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  private String usuarioUpdate;

  @JsonProperty("fechaDelete")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  private Date fechaDelete ;

  @JsonProperty("usuarioDelete")
  @JsonInclude(JsonInclude.Include.NON_ABSENT)  // Exclude from JSON if absent
  private String usuarioDelete;

/*
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Food food = (Food) o;
    return Objects.equals(this.idAlimento, food.idAlimento) &&
        Objects.equals(this.name, food.name) &&
        Objects.equals(this.tipo, food.tipo) &&
        Objects.equals(this.flagEli, food.flagEli) &&
        Objects.equals(this.fechaInsert, food.fechaInsert) &&
        Objects.equals(this.usuarioInsert, food.usuarioInsert) &&
        Objects.equals(this.fechaUpdate, food.fechaUpdate) &&
        Objects.equals(this.usuarioUpdate, food.usuarioUpdate) &&
        Objects.equals(this.fechaDelete, food.fechaDelete) &&
        Objects.equals(this.usuarioDelete, food.usuarioDelete);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idAlimento, name, tipo, flagEli, fechaInsert, usuarioInsert, fechaUpdate, usuarioUpdate, fechaDelete, usuarioDelete);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Food {\n");

    sb.append("    idAlimento: ").append(toIndentedString(idAlimento)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    tipo: ").append(toIndentedString(tipo)).append("\n");
    sb.append("    flagEli: ").append(toIndentedString(flagEli)).append("\n");
    //sb.append("    fechaInsert: ").append(toIndentedString(fechaInsert)).append("\n");
    sb.append("    usuarioInsert: ").append(toIndentedString(usuarioInsert)).append("\n");
    //sb.append("    fechaUpdate: ").append(toIndentedString(fechaUpdate)).append("\n");
    sb.append("    usuarioUpdate: ").append(toIndentedString(usuarioUpdate)).append("\n");
    //sb.append("    fechaDelete: ").append(toIndentedString(fechaDelete)).append("\n");
    sb.append("    usuarioDelete: ").append(toIndentedString(usuarioDelete)).append("\n");
    sb.append("}");
    return sb.toString();
  }*/

/*
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    sb.append("idAlimento=").append(toIndentedString(idAlimento)).append(",");
    sb.append(" name=").append(toIndentedString(name)).append(",");
    sb.append(" tipo=").append(toIndentedString(tipo)).append(",");
    sb.append(" flagEli=").append(toIndentedString(flagEli)).append(",");
    //sb.append(" fechaInsert=").append(toIndentedString(fechaInsert)).append(",");
    sb.append(" usuarioInsert=").append(toIndentedString(usuarioInsert)).append(",");
    //sb.append(" fechaUpdate=").append(toIndentedString(fechaUpdate)).append(",");
    sb.append(" usuarioUpdate=").append(toIndentedString(usuarioUpdate)).append(",");
    //sb.append(" fechaDelete=").append(toIndentedString(fechaDelete)).append(",");
    sb.append(" usuarioDelete=").append(toIndentedString(usuarioDelete));
    sb.append("}");
    return sb.toString();
  }
*/
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  @Override
  public String toString() {
    return "{" +
            "idAlimento='" + idAlimento + '\'' +
            ", name='" + name + '\'' +
            ", tipo=" + tipo +
            ", flagEli=" + flagEli +
            //", fechaInsert=" + fechaInsert +
            ", usuarioInsert='" + usuarioInsert + '\'' +
            //", fechaUpdate=" + fechaUpdate +
            ", usuarioUpdate='" + usuarioUpdate + '\'' +
            //", fechaDelete=" + fechaDelete +
            ", usuarioDelete='" + usuarioDelete + '\'' +
            '}';
  }
}
