

const myApp = {

    // Préparation des données
    data() {
        console.log("data");
        return {
            counter: 1,
            message: "Hello",
            list: [10, 20, 30],
            axios: null,
            cvs: [],
            activities: null,
            cv: null,
            editable: null,
            errors: [],
            isAddMovie: false,
            newMovie: null
        }
    },

    // Mise en place de l'application
    async mounted() {
        console.log("Mounted ");
        this.axios = await axios.create({
            baseURL: 'http://localhost:8080/',
            timeout: 1000,
            headers: {'Content-Type': 'application/json'},
        });

        this.getCvs();
    },

    methods: {
        // // Place pour les futures méthodes
        // incCounter: function(step) {
        //     console.log("increment counter");
        //     this.counter += step;
        //
        //     this.$refs.info.change(this.counter);
        // },
        //
        // getMovie: async function(id) {
        //     const resp = await axios.get('api/movies/' + id);
        //     return await resp.data;
        // },

        getCvs: function() {
            console.log("clicked");
            this.axios.get("api/cvs")
                .then(cvs => {
                    this.cvs = cvs.data;
                    for (let i = 0; i < this.cvs.length ; i++) {
                        this.activities = this.cvs[i];
                        console.log(this.activities);
                    }
                });
        },

        // deleteMovie: function(id) {
        //     this.axios.delete('api/movies/' + id)
        //         .then(r => {
        //             console.log("movie deleted");
        //             this.getMovies();
        //         });
        // },

        showCv: function(id) {
            this.axios.get('api/person/'+ id + '/cv' )
                .then(r => {
                    console.log("cv fetched to show");
                    this.activities = r.data;
                });
        },
        //
        // editMovie: async function(movie) {
        //     console.log("Movie with id " + movie.id + " is set to be modified");
        //     this.editable = movie;
        // },
        //
        // populateMovies: function() {
        //     this.axios.patch('api/movies/')
        //         .then(r => {
        //             console.log("movies added");
        //             this.getMovies();
        //         });
        // },
        //
        // submitMovie: function(movie) {
        //     this.axios.put('api/movies/' + movie.id, movie)
        //         .then(errors => {
        //             this.errors = errors.data;
        //             this.getMovies();
        //         });
        // },
        //
        // clearEditable: function() {
        //     this.editable = null;
        // },
        //
        // setAddMovie: function(status) {
        //     this.isAddMovie = status;
        //     this.newMovie = {};
        // },
        //
        // addMovie: function(newMovie) {
        //     this.axios.post('api/movies/', newMovie)
        //         .then(errors => {
        //             console.log("new movie added: ", newMovie);
        //             this.errors = errors.data;
        //             this.getMovies();
        //         });
        // },
        //
        // incrementCounter: function() {
        //     this.$refs.counter.increment();
        // }

    }
}

const app = Vue.createApp(myApp);
app.mount('#myApp');