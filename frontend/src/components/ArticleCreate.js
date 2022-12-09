import { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import ArticleService from "../services/ArticleService";

const ArticleCreate = () => {
  const navigate = useNavigate();
  const { id } = useParams();

  const [subject, setSubject] = useState("");
  const [writer, setWriter] = useState("");
  const [content, setContent] = useState("");

  // /create-article/_add : 저장  그 외에는 전부 수정으로 처리
  const saveOrUpdateArticle = (e) => {
    e.preventDefault();
    //저장
    if (id === "add") {
      // {} = [] = 객체명 같은 것
      //{subject,writer,content}  == ArticleService에서 바든 매개변수 article 같은 말
      ArticleService.createArticle({ subject, writer, content }).then(
        (response) => {
          navigate("/");
        }
      );
    } else {
      //수정
      ArticleService.updateArticle({ subject, writer, content }, id).then(
        (response) => {
          navigate("/");
        }
      );
    }
  };

  useEffect(() => {
    if (id !== "add") {
      ArticleService.getArticleById(id).then((response) => {
        setSubject(response.data.subject);
        setWriter(response.data.writer);
        setContent(response.data.content);
      });
    }
  }, [id]);

  return (
    <div>
      {id === "add" ? <h3>ADD Article</h3> : <h3>EDIT Article</h3>}
      <form onSubmit={saveOrUpdateArticle} method="post">
        <div>
          <label>Subject : </label>
          <input
            type="text"
            name="subject"
            onChange={(e) => setSubject(e.target.value)}
            value={subject}
            required
          />
        </div>

        <div>
          <label>Writer : </label>
          <input
            type="text"
            name="writer"
            onChange={(e) => setWriter(e.target.value)}
            value={writer}
            required
          />
        </div>

        <div>
          <label>Content : </label>
          <textarea
            name="content"
            onChange={(e) => setContent(e.target.value)}
            value={content}
            required
          ></textarea>
        </div>
        <button type="submit">{id === "add" ? "SAVE" : "EDIT"}</button>
        <button
          type="button"
          onClick={() => {
            window.history.back();
          }}
        >
          Cancel
        </button>
      </form>
    </div>
  );
};

export default ArticleCreate;
