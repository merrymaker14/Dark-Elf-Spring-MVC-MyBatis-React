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
	}

	componentDidMount() {
		client({method: 'GET', path: 'api'}).done(response => {
			this.setState({books: response.entity});
		});
	}

	render() {
		return (
			<BookList books={this.state.books}/>
		)
	}
}
// end::app[]

// tag::book-list[]
class BookList extends React.Component{
	render() {
		var books = this.props.books.map(book =>
			<Book key={book.id} book={book}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>Название</th>
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
	render() {
		return (
			<tr>
				<td>{this.props.book.name}</td>
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

