/**
 * Created with IntelliJ IDEA.
 * User: Jian-Min Gao [jian-min.gao@hp.com]
 * Date: 2016/2/16
 * Time: 17:54
 */
var Comment = React.createClass({
    render: function () {
        return (
            <div className="comment">
                <h2 className="commentAuthor">
          {this.props.author}
                </h2>
        {this.props.children}
            </div>
            );
    }
});
