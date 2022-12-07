import { useState } from "react";
import ArticleService from "../services/ArticleService";

const ArticleCreate = () => {
  const [subject, setSubject] = useState("");
  const [writer, setWriter] = useState("");
  const [content, setContent] = useState("");

  // /create-article/_add : 저장  그 외에는 전부 수저응로 처리
  const saveOrUpdateArticle = (e) => {
    e.preventDefault();
    //저장

    //수정
  };

  return (
    <div>
      <h1>Create Article</h1>
      <form action={saveOrUpdateArticle} method="post">
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
        <button type="submit">Save</button>
        <button type="button">Cancel</button>
      </form>
    </div>
  );
};

export default ArticleCreate;
