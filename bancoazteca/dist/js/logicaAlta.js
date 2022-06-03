$(document).ready(function () {

    $('#AgregarCliente').click(function (e) {
        e.preventDefault();
        var data;
        var url = "http://localhost:8090/api/cliente/guardar/";
        //Lleno la variable data
            data = JSON.stringify({           
              nombre: $('#nombre').val(),
              fechaNac: $('#fecha').val(),
              celular: $('#celular').val(),
              correo: $('#correo').val(),
            });

            $.ajax({
              method: "POST",
              url: url,
              data: data,
              dataType: 'json',
              contentType: "application/json",
              success: function (data) {
                console.log('Enviando ...');
                $('.alert-success').html('Se añadio el cliente').fadeIn().delay(4000).fadeOut('snow');
              },
              error: function (errors) {
                $('.alert-success').html('No fue posible añadir el cliente').fadeIn().delay(4000).fadeOut('snow');
                console.log(errors);
              }
            });

            $('#Nombre').val('');
            $('#Edad').val('')
            $('#Celular').val('')
            $('#Correo').val('')
      });


});