$(document).ready(function () {
    $(document).on('click', '.js_addComment', function () {
        event.preventDefault();
        var $this = $(this);
        var film_id=$this.data('film_id');
        $.ajax({
            type: 'POST',
            url: '/movie/addComment',
            data: {filmId: film_id,
            text: $('textarea#msg').val()
            }

        }).done(function (data) {
            //console.log(data);
            if (data != '') {
                $('.comments-section-grids').append(data);
            } else {
                $this.hide();
            }
        }).fail(function () {
            $this.hide();
            alert("Приносим извинения.<br/>На сервере произошла ошибка");
        });
    });
});