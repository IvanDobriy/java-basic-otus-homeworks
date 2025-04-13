CREATE TABLE public.questions (
	question_id numeric(22) NOT NULL,
	"text" varchar NOT NULL,
	CONSTRAINT questions_pk PRIMARY KEY (question_id)
);

CREATE TABLE public.answers (
	answer_id numeric(22) NOT NULL,
	"text" varchar NOT NULL,
	CONSTRAINT answers_pk PRIMARY KEY (answer_id)
);

CREATE TABLE public.tests (
	test_id numeric(22) NOT NULL,
	title varchar NOT NULL,
	description varchar NOT NULL,
	CONSTRAINT tests_pk PRIMARY KEY (test_id)
);


CREATE TABLE public.answer_options (
	answer_option_id numeric(22) NOT NULL,
	question_id numeric(22) NOT NULL,
	answer_id numeric(22) NOT NULL,
	date_from timestamp NULL,
	date_to timestamp NULL,
	option_number int4 NOT NULL,
	is_true bool NULL,
	CONSTRAINT question_answer_options_pk PRIMARY KEY (answer_option_id)
);
CREATE INDEX answer_options_answer_id_idx ON public.answer_options USING btree (answer_id);
CREATE INDEX answer_options_date_from_idx ON public.answer_options USING btree (date_from);
CREATE INDEX answer_options_date_to_idx ON public.answer_options USING btree (date_to);
CREATE INDEX answer_options_question_id_idx ON public.answer_options USING btree (question_id);


-- public.answer_options внешние включи

ALTER TABLE public.answer_options ADD CONSTRAINT answer_options_answers_fk FOREIGN KEY (answer_id) REFERENCES public.answers(answer_id) ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE public.answer_options ADD CONSTRAINT answer_options_questions_fk FOREIGN KEY (question_id) REFERENCES public.questions(question_id) ON DELETE RESTRICT ON UPDATE CASCADE;


CREATE TABLE public.test_questions (
	test_question_id numeric(22) NOT NULL,
	test_id numeric(22) NOT NULL,
	question_id numeric(22) NOT NULL,
	date_from timestamp NULL,
	date_to timestamp NULL,
	CONSTRAINT test_questions_pk PRIMARY KEY (test_question_id)
);
CREATE INDEX test_questions_date_from_idx ON public.test_questions USING btree (date_from);
CREATE INDEX test_questions_date_to_idx ON public.test_questions USING btree (date_to);
CREATE INDEX test_questions_question_id_idx ON public.test_questions USING btree (question_id);
CREATE INDEX test_questions_test_id_idx ON public.test_questions USING btree (test_id);


-- public.test_questions внешние включи

ALTER TABLE public.test_questions ADD CONSTRAINT test_questions_questions_fk FOREIGN KEY (question_id) REFERENCES public.questions(question_id) ON DELETE RESTRICT ON UPDATE CASCADE;
ALTER TABLE public.test_questions ADD CONSTRAINT test_questions_tests_fk FOREIGN KEY (test_id) REFERENCES public.tests(test_id) ON DELETE RESTRICT ON UPDATE CASCADE;
