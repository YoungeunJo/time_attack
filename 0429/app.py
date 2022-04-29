from datetime import datetime

from flask import Flask, render_template, jsonify, request
from pymongo import MongoClient

app = Flask(__name__)

client = MongoClient("mongodb:#localhost:27017/")
db = client.test


@app.route('/')
def index():
    return render_template('index.html')


@app.route('/detail/<idx>')
def detail(idx):
    return render_template("detail.html")

@app.route('/post', methods=['POST'])
def save_post():
    # todo
    postUrl_receive = request.form['postUrl_give']
    postPw_receive = request.form['postPw_give']
    postComment_receive = request.form['postComment_give']

    today = datetime.now()
    mytime = today.strftime('%Y-%m-%d-%H-%M-%S')

    doc = {
            'title': postUrl_receive,
            'content': postPw_receive,
            'comment': postComment_receive,
            'time': mytime
        }
        db.mylist.insert_one(doc)

    return {"result": "success"}


@app.route('/post', methods=['GET'])
def get_post():
    posts = 0
    # todo
    return jsonify({"posts": posts})


@app.route('/post', methods=['DELETE'])
def delete_post():
    idx = request.args.get('idx')
    db.test.delete_one({'idx': int(idx)})
    return {"result": "success"}


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000, debug=True)
