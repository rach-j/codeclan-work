require('sinatra')
require('sinatra/contrib/all')
require_relative('./models/string_checks.rb')

get '/equal/:string1/:string2' do
  strings = StringChecks.new(params[:string1], params[:string2])
  @result = strings.equal?()
  erb(:result)
end

get '/palindrome/:string1' do
  string = StringChecks.new(params[:string1])
  @result = string.palindrome?()
  erb(:result)
end

get '/isogram/:string1' do
  string = StringChecks.new(params[:string1])
  @result = string.isogram?()
  erb(:result)
end

get '/anagram/:string1/:string2' do
  strings = StringChecks.new(params[:string1], params[:string2])
  @result = strings.anagram?()
  erb(:result)
end
