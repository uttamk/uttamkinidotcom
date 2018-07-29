use Mix.Config

# In this file, we keep production configuration that
# you'll likely want to automate and keep away from
# your version control system.
#
# You should document the content of this
# file or create a script for recreating it, since it's
# kept out of version control and might be hard to recover
# or recreate for your teammates (or yourself later on).
config :ublog, UblogWeb.Endpoint,
  secret_key_base: "CCSxyReVRQgQA3QpEZ2Cs1LKy6OLgpulXa0S3noDv7GcIqwtqC2ke5lUPM2YyC4S"

# Configure your database
config :ublog, Ublog.Repo,
  adapter: Ecto.Adapters.Postgres,
  username: "postgres",
  password: "postgres",
  database: "ublog_prod",
  pool_size: 15
