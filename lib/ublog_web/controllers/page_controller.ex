defmodule UblogWeb.PageController do
  use UblogWeb, :controller

  def index(conn, _params) do
    render conn, "index.html"
  end
end
