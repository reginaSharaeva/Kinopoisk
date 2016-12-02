/**
 * Created by Mars on 29.11.2016.
 */

    var SearchExample = React.createClass({

        getInitialState: function(){
            return { searchString: '' };
        },

        handleChange: function(e){

            // Если вы закомментировать эту строку, текстовое поле не изменит своего значения.
            // Это потому, что в React поле не может измениться независимо от свойства,
            // которое было ему присвоено. В нашем случае это this.state.searchString.

            this.setState({searchString:e.target.value});
        },

        render: function() {



            var  movies = this.props.items;
            var   searchString = this.state.searchString.trim().toLowerCase();


            if(searchString.length > 0){

                // Ищем и фильтрируем резальтаты.

                var name="name="+"Home Run";
                // var name="Home Run";
                // var xhr = new XMLHttpRequest();
                // var params = 'name=' + encodeURIComponent(name);
                // xhr.open('POST', '/movie/search', true);
                // xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')

                // xhr.send(params);
                //xhr.onreadystatechange = function() {
                //  if (xhr.readyState == 4) {
                // if(xhr.status == 200) {
                ///      movies=(JSON.parse(xhr.responseText));

                //  }
                // }
                //}


                fetch('/movie/search',{ method: 'POST', headers: {
                    "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"},   body: name })
                    .then(function(response) {

                        response.json().then(function(json) {

                            movies=json;


                        });
                    });

                alert(movies.length);


                //    alert(movies)



                // alert(movies.length)
                // for(var l in movies) {

                //    alert( movies[l].name);
                // }
                // alert(movies);
                //alert(movies.length);
            }

            return <div>
                <input id="search" type="text" value={this.state.searchString} onChange={this.handleChange} placeholder="Введите здесь" />

                <ul>
                    { movies.map(function(l){
                        return <li>{l.name} </li>
                    }) }


                    }


                </ul>

            </div>;

        },

    });


var movies = [


];








