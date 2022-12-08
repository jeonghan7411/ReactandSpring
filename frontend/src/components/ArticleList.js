import { useEffect, useState } from "react";
import ArticleService from "../services/ArticleService";
import { useNavigate, useParams } from "react-router-dom";
import moment from "moment";

const ArticleList = () => {
  const [articles, setArticles] = useState([]);

  const navigate = useNavigate();

  const deleteArticle = (id) => {
    ArticleService.deleteArticle(id).then((response) => {
      window.alert("Delete Completed");
      //삭제된 내용을 검색하여 삭제할 내용은 제외하고 다시 변수에 넣기
      //0articles 배열 안에 있는 id들과 매개변수로 받은 id를 하나하나 비교해서
      //다시 저장
      setArticles(articles.filter((a) => a.id !== id));
    });
  };

  const editArticle = (id) => {
    //페이지 이동 (id값을 가지고 이동)
    navigate(`/create-article/${id}`);
  };

  //function으로 구현했을 때
  function viewArticle(id) {}

  useEffect(() => {
    ArticleService.getArticles().then((response) => {
      setArticles(response.data);
    });
  }, []);

  return (
    <div>
      <a href="/create-article/add">Create Article</a>
      <table border="1">
        <thead>
          <tr>
            <th>ID.</th>
            <th>Subject.</th>
            <th>Writer</th>
            <th>Regdate.</th>
            <th>Edit / Delete / View</th>
          </tr>
        </thead>
        <tbody>
          {articles.map((article, key) => {
            return (
              <tr key={key}>
                <td>{article.id}</td>
                <td>{article.subject}</td>
                <td>{article.writer}</td>
                <td>{moment(article.regdate).format("YYYY년MM월DD일")}</td>
                <td>
                  <button onClick={() => editArticle(article.id)}>Edit</button>/
                  <button onClick={() => deleteArticle(article.id)}>
                    Delete
                  </button>
                  /<button onClick={() => viewArticle(article.id)}>View</button>
                </td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
};

export default ArticleList;
