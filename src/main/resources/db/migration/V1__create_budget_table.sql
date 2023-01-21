DROP TABLE IF EXISTS "budget";

CREATE TABLE IF NOT EXISTS "budget" (
  uuid UUID PRIMARY KEY,
  "month" INTEGER NOT NULL,
  "year" INTEGER NOT NULL,
  "ins" jsonb DEFAULT '{}'::jsonb,
  "outs" jsonb DEFAULT '{}'::jsonb,
  "created_at" TIMESTAMP NOT NULL,
  "updated_at" TIMESTAMP NOT NULL
);