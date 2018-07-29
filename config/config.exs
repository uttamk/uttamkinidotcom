# This file is responsible for configuring your application
# and its dependencies with the aid of the Mix.Config module.
#
# This configuration file is loaded before any dependency and
# is restricted to this project.
use Mix.Config

# General application configuration
config :ublog,
  ecto_repos: [Ublog.Repo]

# Configures the endpoint
config :ublog, UblogWeb.Endpoint,
  url: [host: "localhost"],
  secret_key_base: "OlEtmAEO4MnEuFlib1c5Ivdqg38aM8g6fZFwUa7Q9cTImpkz/nfq9kw4XbFuWVup",
  render_errors: [view: UblogWeb.ErrorView, accepts: ~w(html json)],
  pubsub: [name: Ublog.PubSub,
           adapter: Phoenix.PubSub.PG2]

# Configures Elixir's Logger
config :logger, :console,
  format: "$time $metadata[$level] $message\n",
  metadata: [:user_id]

# Import environment specific config. This must remain at the bottom
# of this file so it overrides the configuration defined above.
import_config "#{Mix.env}.exs"
