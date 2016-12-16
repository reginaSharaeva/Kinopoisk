/**
 * Created by Mars on 29.11.2016.
 */
var Movie = React.createClass({
    render: function () {
        let movie = this.props.movie;
        return <li>
            <div className="owl-item active" style={{
                width: "270px",
                marginRight: "20px",
                marginTop: "50px",
                marginBottom:"50px",
            }}>
                <div className="owl-item">
                    <a href={'/movie/' + movie.id} className="thumb mfp-image">
                        <img src={movie.img} alt=""/>
                    </a>
                    <h5>
                        <a href={'/movie/' + movie.id}
                           className="text-secondary">{movie.name}</a></h5>
                    <p>{movie.description}</p>
                </div>
            </div>
        </li>
    }
});


var Sort = React.createClass({
    sort(){
     this.props.sort(document.getElementById("sort").value);
    },

    render: function () {
        return<div id="filter-panel">
                <div className="panel panel-default">
                    <div className="panel-body">
                        <form className="form-inline" role="form">
                            <div className="form-group">
                                <label className="filter-col" htmlFor="pref-orderby">Сортировать
                                    по:</label>
                                <select  id="sort" className="form-control" onChange={this.sort}>
                                    <option value="totalraiting" >Рейтинг</option>
                                    <option selected value="year" >Год выпуска</option>
                                </select>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

    }

});

var Filter = React.createClass({
    filter(){
        var filters;
        var genres=[];
        $( ':checkbox:checked' ).each(function(){
            genres.push(this.value);
            filters=filters+this.value+",";
        });
        filters="genres="+genres;
        filters=filters+"&from="+document.getElementById("from").value;
        filters=filters+"&to="+document.getElementById("to").value+"&";
        this.props.filter(filters);
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
        return <div id="accordion" className="panel panel-primary behclick-panel">
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
                        <input id="to" type="text" className="form-control" style={{width: "200px"}}
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
                    <button onClick={this.filter} style={{marginLeft: "180px",marginBottom:"20px"}} type="submit" className="btn btn-success ">
                        Найти
                    </button>
                </div>
            </div>

    }
});


var Search = React.createClass({


    handleChange: function () {
        var searchString = document.getElementById("search").value.trim().toLowerCase();
        this.props.autocompleteByName(searchString);
        document.getElementById("search").onkeydown=this.handle;
    },
    handleChangeSearchBy(){
        var searchString = document.getElementById("search").value.trim().toLowerCase();
        var searchBy= document.getElementById("searchBy").value;
        this.props.search(searchString,searchBy);
    },

     handle: function(e) {
      if(e.keyCode==13){
          var searchString = document.getElementById("search").value.trim().toLowerCase();
          var searchBy= document.getElementById("searchBy").value;
          this.props.search(searchString,searchBy);
      }

     },
    render: function () {
        return  <div className="input-group">
            <div className="input-group-btn search-panel">

            <select   id="searchBy" className="form-control" onChange={this.handleChangeSearchBy}>
            <option value="name" selected ="">Искать по названию</option>
            <option value="persons.firstName" >Искать по участикам</option>
            <option value="description">Искать по описанию </option>
        </select>
            </div>
         <div className="ui-widget">
            <input   id="search" type="text" className="form-control"
                     onChange={this.handleChange}
                     placeholder="Введите здесь"/>
         </div>
        </div>
    },

});


var App = React.createClass({
    getInitialState: function () {
        return {movies: [], genres: [],sortBy:"year",searchString: '',searchBy:"name",filters:"genres=&from=&to=&"};
    },
    componentWillMount: function () {
        this.loadMovies();
        this.loadGenres();
    },

    sort(sortBy){
        this.setState({sortBy:sortBy});
        this.searchFull(this.state.searchString,this.state.searchBy,this.state.filters,sortBy);
    },

    filter(filters){
        this.setState({filters:filters});
        this.searchFull(this.state.searchString,this.state.searchBy,filters,this.state.sortBy);
    },


    search(searchString,searchBy){
        this.setState({searchString:searchString,searchBy:searchBy});
        this.searchFull(searchString,searchBy,this.state.filters,this.state.sortBy);

    },


    searchFull(searchString,searchBy,filters,sortBy){
        var requestBody=filters+"sort="+sortBy+"&search="+searchString+"&searchBy="+searchBy;
        var self = this;
        fetch('/movie/fullSearch', {
            method: 'POST', headers: {
                "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"
            }, body: requestBody
        }).then(function (response) {
            response.json().then(function (json) {
                self.setState({movies: json});
            });
        });
    },




    loadMovies(){
   var self = this;
   var reqBody="sort="+self.state.sortBy;
        fetch('/movie/getAllMovies', {
            method: 'POST', headers: {
                "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"
            },body:reqBody
        }).then(function (response) {
            response.json().then(function (json) {
                self.setState({movies: json});
            });
        });
    },
    autocompleteByName(searchString){
        this.setState({searchString:searchString});
    var param = "q=" + searchString;
        let obj = [];
        fetch('/movie/autocomplete', {
            method: 'POST', headers: {
                "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"
            }, body: param
        })
            .then(function (response) {
                response.json().then(function (json) {
                    let data = json;
                     data.hits.hits.map(h => {
                            if (h.highlight && h.highlight.hasOwnProperty("name")) {
                                obj.push(h.highlight.name.toString());
                            } else {
                                obj.push(h._source.name.toString());
                            }
                        })
                    jQuery("#search").autocomplete({
                        source: obj
                    });
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

        return <div className="container-fluid">
             <div className="row">
                 <div className="col-lg-4 col-md-4 col-xs-4" >

                     <Sort sort={this.sort}/>
                     <Filter genres={this.state.genres} filter={this.filter}/>
                 </div>

                <div className="col-lg-8 col-md-8 col-xs-8 " >

                    <Search search={this.search} autocompleteByName={this.autocompleteByName}/>
                    <ul >
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







