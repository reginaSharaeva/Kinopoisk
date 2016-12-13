/**
 * Created by Mars on 29.11.2016.
 */
var Movie = React.createClass({
    render: function () {
        let movie = this.props.movie;
        return <li>
            <div className="owl-item active" style={{
                width: "270px",
                marginRight: "30px",
                marginTop: "50px"}}>
                <div className="owl-item">
                    <a href={movie.img} className="thumb mfp-image">
                        <img src={movie.img} alt=""/>
                    </a>
                    <h5><a href={'/movie/' + movie.id}
                           className="text-secondary">{movie.name}</a></h5>
                    <p>{movie.description}</p>
                </div>
            </div>
        </li>
    }
});


var Sort = React.createClass({
    render: function () {
        return  <div className="col-lg-4 col-md-4 col-xs-4" style={{marginLeft:"450px"}}>
            <div id="filter-panel">
                <div className="panel panel-default">
                    <div className="panel-body">
                        <form className="form-inline" role="form">
                            <div className="form-group">
                                <label className="filter-col" htmlFor="pref-orderby">Сортировать
                                    по:</label>
                                <select id="pref-orderby" className="form-control">
                                    <option>Рейтинг</option>
                                    <option>Год выпуска</option>
                                </select>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    }

});

var Filter = React.createClass({

    filter(){
        var requestBody;
        var genres=[];
        $( ':checkbox:checked' ).each(function(){
            genres.push(this.value);
            requestBody=requestBody+this.value+",";
        });
        requestBody="genres="+genres;
        requestBody=requestBody+"&from="+document.getElementById("from").value;

        requestBody=requestBody+"&before="+document.getElementById("before").value;


        this.props.filter(requestBody);
    },
    render: function () {
        let genres = this.props.genres.map(genre => {
            return <li className="list-group-item">
                <div className="checkbox">
                    <form id="genres">
                    <label>
                        <input  type="checkbox" value={genre} />
                        {genre}
                    </label>
                    </form>
                </div>
            </li>
        });
        return <div className="col-lg-4 col-md-4 col-xs-4">
            <div id="accordion" className="panel panel-primary behclick-panel">
                <div className="panel-heading">
                    <h3 className="panel-title">Фильтры</h3>
                </div>
                <div className="panel-body">
                    <div className="panel-heading ">
                        <h4 className="panel-title">
                            <a data-toggle="collapse" href="#collapse0">
                                <i className="indicator fa fa-caret-down" aria-hidden="true"/> Год выпуска
                            </a>
                        </h4>
                    </div>
                    <div id="collapse0" className="panel-collapse collapse in"  style={{marginLeft: "20px"}}>
                        <label style={{marginTop: "10px"}} >От</label>
                        <input className="form-control" style={{width: "200px"}} id="from" type="text"
                               placeholder="Год"/>
                        <label style={{marginTop: "10px"}}>До</label>
                        <input id="before" type="text" className="form-control" style={{width: "200px"}}
                               placeholder="Год"/>
                    </div>
                    <div className="panel-heading">
                        <h4 className="panel-title">
                            <a data-toggle="collapse" href="#collapse3"><i className="indicator fa fa-caret-down"
                                                                           aria-hidden="true"/> Жанр</a>
                        </h4>
                    </div>
                    <div id="collapse3" className="panel-collapse collapse in">
                        <ul className="list-group">
                            {genres}
                        </ul>
                    </div>
                    <button onClick={this.filter} style={{marginLeft: "130px",marginBottom:"20px"}} type="submit" className="btn btn-success ">
                        Найти
                    </button>
                </div>
            </div>
        </div>
    }
});


var Search = React.createClass({

    getInitialState: function () {
        return {searchString: ''};
    },


    handleChange: function (e) {
        this.setState({searchString: e.target.value});
        var searchString = this.state.searchString.trim().toLowerCase();
        if (searchString.length > 0) {
            //this.props.autocomplete();
            var name = "name=" + searchString;
            this.props.search(name);
        }
    },


    render: function () {


        return <div>
            <input id="search" type="text" className="form-control" value={this.state.searchString}
                   onChange={this.handleChange}
                   placeholder="Введите здесь"/>
        </div>
    },

});


var App = React.createClass({
    getInitialState: function () {
        return {movies: [], genres: []};
    },
    componentWillMount: function () {
        this.loadMovies();
        this.loadGenres();


    },

    filter(requestBody){
        var self = this;

        fetch('/movie/filter', {
            method: 'POST', headers: {
                "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"
            }, body: requestBody
        }).then(function (response) {
            response.json().then(function (json) {
                self.setState({movies: json});
            });
        });
    },




    search(name){
        var self = this;
        fetch('/movie/search', {
            method: 'POST', headers: {
                "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"
            }, body: name
        }).then(function (response) {

            response.json().then(function (json) {

                self.setState({movies: json});


            });
        });


    },


    loadMovies(){

        var self = this;
        fetch('/movie/getAllMovies', {
            method: 'GET', headers: {
                "Content-type": "application/json; charset=UTF-8"
            }
        }).then(function (response) {

            response.json().then(function (json) {

                self.setState({movies: json});


            });
        });

    },
    autocomplete(){

        var param = "q=" + this.state.searchString;
        var der = this;
        fetch('/movie/autocomplete', {
            method: 'POST', headers: {
                "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"
            }, body: param
        })
            .then(function (response) {
                response.json().then(function (json) {

                    let data = json;

                    der.setState({
                        movies: data.hits.hits.map(h => {
                            let obj = {};
                            if (h.highlight && h.highlight.hasOwnProperty("name")) {
                                obj.name = h.highlight.name;
                            } else {
                                obj.name = h._source.name;
                            }

                            if (h.highlight && h.highlight.hasOwnProperty("description")) {
                                obj.description = h.highlight.description;
                            } else {
                                obj.description = h._source.description;
                            }
                            obj.img = h._source.img;
                            obj.id = h._source.id;

                            return obj;
                        })
                    })

                });
            })
    },

    loadGenres(){
        var self = this;

        fetch('/movie/genresFromFilter', {
            method: 'GET', headers: {
                "Content-type": "application/json; charset=UTF-8"
            }
        }).then(function (response) {
            response.json().then(function (json) {

                self.setState({genres: json});


            });
        });

    },


    render: function () {
        let movies = this.state.movies.map((movie) => {
            return <Movie movie={movie} key={movie.id}/>
        });

        return <div className="container">
            <div className="row">
                <Sort/>
            </div>

            <div className="row">
                <Filter genres={this.state.genres} filter={this.filter}/>
                <div className="col-lg-8 col-md-8 col-xs-8">
                    <Search search={this.search} autocomplete={this.autocomplete}/>
                    <ul>
                        {movies}
                    </ul>
                </div>
            </div>

        </div>
    }

});


// Отображаем на странице компонент Search

ReactDOM.render(
    <App />,
    document.getElementById("root")
);







