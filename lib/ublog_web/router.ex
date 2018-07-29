defmodule UblogWeb.Router do
  use UblogWeb, :router

  pipeline :browser do
    plug :accepts, ["html"]
    plug :fetch_session
    plug :fetch_flash
    plug :protect_from_forgery
    plug :put_secure_browser_headers
  end

  pipeline :api do
    plug :accepts, ["json"]
  end

  scope "/", UblogWeb do
    pipe_through :browser # Use the default browser stack

    get "/", LandingPageController, :index
  end

  # Other scopes may use custom stacks.
  # scope "/api", UblogWeb do
  #   pipe_through :api
  # end
end
