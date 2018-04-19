require('sinatra')
require('sinatra/contrib/all')
require('pry-byebug')
require_relative('./models/student.rb')

get '/studentregistry' do
  @students = Student.all()
  erb(:index)
end

get '/studentregistry/new' do
  erb(:new)
end

get '/studentregistry/:id' do
  @student = Student.find(params[:id].to_i())
  erb(:show)
end

post '/studentregistry/:id/delete' do
  @student = Student.find(params[:id].to_i())
  @student.delete()
  redirect to '/studentregistry'
end

post '/studentregistry' do
  @student = Student.new(params)
  @student.save()
  erb(:create)
end

get '/studentregistry/:id/edit' do
  @student = Student.find(params[:id].to_i())
  erb(:edit)
end

post '/studentregistry/:id' do
  @student = Student.new(params)
  @student.update()
  redirect to '/studentregistry'
end
