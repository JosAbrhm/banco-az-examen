$(document).ready(function () {

  mostrarEmpleados();

  //Funcion para agregar
  $('#AgregarEmpleado').click(function (e) {
    e.preventDefault();   //Detiene la llamada que el formulario haría por si solo
    var data; // contendrá la informacion que le ponga al form
    var url = "http://localhost:8085/api/empleado/añadir";  //endpoint del backend encargado de guardar
    //Empaqueto en un JSON la informacion puesta en los input del form
    data = JSON.stringify({
      nombre: $('#nombre').val(),
      antiguedad: $('#antiguedad').val(),
      sexo: $('#sexo').val(),
      estadoCivil: $('#estadocivil').val(),
      fechaNac: $('#fecha').val(),
      cargoId: $('#cargoId').val()
    });
    //Peticion asincrona
    $.ajax({
      method: "POST",
      url: url,
      data: data,
      dataType: 'json',
      contentType: "application/json",
      success: function (data) {
        console.log('Exito');
        mostrarEmpleados();

      },
      error: function (errors) {
        console.log('Error');
      }
    });

  });



  $("#btnEditarEmpleado").click(function (e) {
    e.prevenDefault();

    var url = "http://localhost:8085/api/empleado/actualizar";
    var data = JSON.stringify({
      empleadoId: e,
      nombre: $('#nombre_edit').val(),
      antiguedad: $('#antiguedad_edit').val(),
      sexo: $('#sexo_edit').val(),
      estadoCivil: $('#estadocivil_edit').val(),
      fechaNac: $('#fecha_edit').val(),
      cargoId: $('#cargoId_edit').val()
    });

    $.ajax({
      method: "PUT",
      url: url,
      data: data,
      dataType: 'json',
      contentType: "application/json",
      success: function (data) {
        console.log('Actualizando ...');
        mostrarEmpleados();

      },
      error: function (errors) {
        console.log('Error');
      }
    });


  });

});


function mostrarModalEditar(e){
  var url = "http://localhost:8085/api/empleado/buscar-por-id/"+e;

  $.ajax({
    method: "GET",
    url: url,
    dataType: 'json',
    success:function(response, data){

      //Seteo en los input del formulario de editar la informacion que me responde el servidor
      $('#nombre_edit').val(response.nombre);
      $('#antiguedad_edit').val(response.antiguedad);
      $('#sexo_edit').val(response.sexo);
      $('#estadocivil_edit').val(response.estadocivil);
      $('#fecha_edit').val(response.fecha);
      $('#cargoId_edit').val(response.cargoId);

      //mostra el modal
      $('#modalEditar').modal("show");

    },
    error:function(errors){
      console.log('Error al rellenar form de editar');
    }
  });


}


function mostrarEmpleados() {
  $.get("http://localhost:8085/api/empleado/listar-empleados", function (response, state) {
    //$("#proveedor").empty();
    $("tbody").children().remove();  //Limpia los elementos que hay en la tabla

    for (i = 0; i < response.length; i++) {

      console.log(response[i].nombre);
      $('#tablaEmpleados').append(
        '<tr><td align="center">' +
        response[i].nombre + '</td><td align="center">'
        + response[i].antiguedad + '</td><td align="center">'
        + response[i].sexo + '</td><td align="center">'
        + response[i].estadoCivil + '</td><td align="center">'
        + response[i].fechaNac + '</td><td align="center">'
        + response[i].cargoId + '</td><td align="center">'
        + response[i].status + '</td><td align="center">'
        + '<button type="button" class="btn btn-warning col-sm-8" id="btnEdit" onclick="mostrarModalEditar(' + response[i].empleadoId + ')"><i class="fa fa-edit"></i></button></td><td align="center"><button type="button" class="btn btn-danger col-sm-8" onclick="eliminarGenero(' + response[i].empleadoId + ')"><i class="fa fa-ban"></i></button></td></tr>');
    }
  }, 'json');
}