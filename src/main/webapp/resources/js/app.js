'use strict';

// tag::vars[]
const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');
// end::vars[]

// tag::app[]
class App extends React.Component {
	constructor(props) {
		super(props);
		this.state = {books: []};
		this.onDelete = this.onDelete.bind(this);
	}
	
	onDelete(book) {
		client({method: 'POST', path: 'http://localhost:8080/main/book/' + book.id + '/delete'}).done(response => {
			console.log('onDelete: ', book.id);
			client({method: 'GET', path: 'api'}).done(response => {
				console.info("onDelete response: %o", response);
				this.setState({books: response.entity});
				
			});
		});
	}

	componentDidMount() {
		client({method: 'GET', path: 'api'}).done(response => {
			console.info("componentDidMount response: %o", response);
			this.setState({books: response.entity});
		});
	}
	
	render() {
		return (
			<BookList books={this.state.books} onDelete={this.onDelete}/>
		)
	}
}
// end::app[]

// tag::book-list[]
class BookList extends React.Component{
	constructor(props) {
		super(props);
	}
	
	render() {
		var books = this.props.books.map(book =>
			<Book key={book.id} book={book} onDelete={this.props.onDelete}/>
		);
		return (
			<table id="example" className="display nowrap" style={{width: '100%'}}>
				<tbody>
					<tr>
						<th>Название</th>
						<th>Автор</th>
						<th>Издательство</th>
						<th>Год издания</th>
					</tr>
					{books}
				</tbody>
			</table>
		)
	}
}
// end::book-list[]

// tag::book[]
class Book extends React.Component{
	constructor(props) {
		super(props);
		this.handleDelete = this.handleDelete.bind(this);
	}
	
	handleDelete() {
		this.props.onDelete(this.props.book);
	}
	
	render() {
		const { id, name, author, publishingHouse, theYearOfPublishing } = this.props.book;
		
		return (
			<tr>
				<td><a href={"http://localhost:8080/main/book/book?id=" + id}>{name}</a></td>
				<td onClick={() => { this.handleDelete() }}>{author}</td>
				<td>{publishingHouse}</td>
				<td>{theYearOfPublishing}</td>
			</tr>
		)
	}
}
// end::book[]

// tag::render[]
ReactDOM.render(
	<App />,
	document.getElementById('react')
)
// end::render[]

